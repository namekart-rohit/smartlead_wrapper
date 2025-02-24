package com.smartlead.backend.Service.impl;

import com.smartlead.backend.Entity.Contact;
import com.smartlead.backend.Entity.Lead;
import com.smartlead.backend.Respository.ContactRepository;
import com.smartlead.backend.Respository.LeadRepository;
import com.smartlead.backend.Service.LeadService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LeadImpl implements LeadService {

    private final LeadRepository leadRepository;
    private final ContactRepository contactRepository;

    public LeadImpl(LeadRepository leadRepository, ContactRepository contactRepository) {
        this.leadRepository = leadRepository;
        this.contactRepository = contactRepository;
    }

    @Override
    public Lead createLead(Lead lead) {
        lead.setCreatedAt(LocalDateTime.now());
        return leadRepository.save(lead);
    }

    @Override
    public Optional<Lead> getLeadById(Long leadId) {
        return leadRepository.findByLeadIdAndDeletedAtIsNull(leadId);
    }

    @Override
    public List<Lead> getAllLeads() {
        return leadRepository.findAllByDeletedAtIsNull();
    }

    @Override
    public Lead updateLead(Long leadId, Lead lead) {
        lead.setLeadId(leadId);
        lead.setUpdatedAt(LocalDateTime.now());
        return leadRepository.save(lead);
    }

    @Override
    @Transactional
    public void deleteLead(Long leadId) {
        // Soft delete the lead
        Optional<Lead> leadOpt = leadRepository.findByLeadIdAndDeletedAtIsNull(leadId);
        if (leadOpt.isPresent()) {
            Lead lead = leadOpt.get();
            lead.setDeletedAt(LocalDateTime.now());
            leadRepository.save(lead);

            // Soft delete all contacts associated with this lead
            List<Contact> contacts = contactRepository.findByLead_LeadIdAndDeletedAtIsNull(leadId);
            for (Contact contact : contacts) {
                contact.setDeletedAt(LocalDateTime.now());
                contactRepository.save(contact);
            }
        }
    }

    @Override
    public List<Lead> getAllDeletedLeads() {
        return leadRepository.findAllByDeletedAtIsNotNull();
    }

}