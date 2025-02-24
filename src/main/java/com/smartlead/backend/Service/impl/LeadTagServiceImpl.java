package com.smartlead.backend.Service.impl;


import com.smartlead.backend.Entity.Lead;
import com.smartlead.backend.Entity.LeadTag;
import com.smartlead.backend.Entity.LeadTagId;
import com.smartlead.backend.Entity.Tag;
import com.smartlead.backend.Respository.LeadRepository;
import com.smartlead.backend.Respository.LeadTagRepository;
import com.smartlead.backend.Respository.TagRepository;
import com.smartlead.backend.Service.LeadTagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LeadTagServiceImpl implements LeadTagService {

    private final LeadTagRepository leadTagRepository;
    private final LeadRepository leadRepository;
    private final TagRepository tagRepository;
    public LeadTagServiceImpl(LeadTagRepository leadTagRepository, LeadRepository leadRepository, TagRepository tagRepository) {
        this.leadTagRepository = leadTagRepository;
        this.leadRepository = leadRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    public LeadTag createLeadTag(LeadTag leadTag) {
        // Extract the composite key
        Long leadId = leadTag.getId().getLeadId();
        Long tagId = leadTag.getId().getTagId();

        // Retrieve the associated Lead and Tag (make sure you have repositories injected)
        Optional<Lead> leadOpt = leadRepository.findById(leadId);
        Optional<Tag> tagOpt = tagRepository.findById(tagId);

        if (leadOpt.isEmpty() || tagOpt.isEmpty()) {
            throw new RuntimeException("Lead or Tag not found for given IDs");
        }

        // Set the associations
        leadTag.setLead(leadOpt.get());
        leadTag.setTag(tagOpt.get());

        // Save the entity with the composite key and associations set
        return leadTagRepository.save(leadTag);
    }

    @Override
    public Optional<LeadTag> getLeadTag(LeadTagId id) {
        return leadTagRepository.findById(id);
    }

    @Override
    public List<LeadTag> getAllLeadTags() {
        return leadTagRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteLeadTag(LeadTagId id) {
        leadTagRepository.deleteById(id);
    }
}