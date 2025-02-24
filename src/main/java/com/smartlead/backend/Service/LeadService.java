package com.smartlead.backend.Service;


import com.smartlead.backend.Entity.Lead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface LeadService {
    Lead createLead(Lead lead);
    Optional<Lead> getLeadById(Long leadId);
    List<Lead> getAllLeads();
    Lead updateLead(Long leadId, Lead lead);
    void deleteLead(Long leadId);  // Soft delete
    List<Lead> getAllDeletedLeads();
}