package com.smartlead.backend.Respository;

import com.smartlead.backend.Entity.LeadTag;
import com.smartlead.backend.Entity.LeadTagId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LeadTagRepository extends JpaRepository<LeadTag, LeadTagId> {
    List<LeadTag> findByTag_TagId(Long tagId);
    List<LeadTag> findByLead_LeadId(Long leadId);
}
