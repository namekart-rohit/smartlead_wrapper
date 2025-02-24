package com.smartlead.backend.Controller;


import com.smartlead.backend.Entity.LeadTag;
import com.smartlead.backend.Entity.LeadTagId;
import com.smartlead.backend.Service.LeadTagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lead-tags")
public class LeadTagController {

    private final LeadTagService leadTagService;

    public LeadTagController(LeadTagService leadTagService) {
        this.leadTagService = leadTagService;
    }

    // Create a new LeadTag (associate a Tag with a Lead)
    @PostMapping
    public ResponseEntity<LeadTag> createLeadTag(@RequestBody LeadTag leadTag) {
        LeadTag createdLeadTag = leadTagService.createLeadTag(leadTag);
        return ResponseEntity.ok(createdLeadTag);
    }

    // Get a specific LeadTag by composite key (leadId and tagId)
    @GetMapping("/{leadId}/{tagId}")
    public ResponseEntity<LeadTag> getLeadTag(@PathVariable("leadId") Long leadId,
                                              @PathVariable("tagId") Long tagId) {
        LeadTagId id = new LeadTagId(leadId, tagId);
        return leadTagService.getLeadTag(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get all LeadTag associations
    @GetMapping
    public ResponseEntity<List<LeadTag>> getAllLeadTags() {
        List<LeadTag> leadTags = leadTagService.getAllLeadTags();
        return ResponseEntity.ok(leadTags);
    }

    // Delete a LeadTag association
    @DeleteMapping("/{leadId}/{tagId}")
    public ResponseEntity<Void> deleteLeadTag(@PathVariable("leadId") Long leadId,
                                              @PathVariable("tagId") Long tagId) {
        LeadTagId id = new LeadTagId(leadId, tagId);
        leadTagService.deleteLeadTag(id);
        return ResponseEntity.ok().build();
    }
}