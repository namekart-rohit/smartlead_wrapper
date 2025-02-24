package com.smartlead.backend.Service;


import com.smartlead.backend.Entity.LeadTag;
import com.smartlead.backend.Entity.LeadTagId;

import java.util.List;
import java.util.Optional;

public interface LeadTagService {
    LeadTag createLeadTag(LeadTag leadTag);
    Optional<LeadTag> getLeadTag(LeadTagId id);
    List<LeadTag> getAllLeadTags();
    void deleteLeadTag(LeadTagId id);
}