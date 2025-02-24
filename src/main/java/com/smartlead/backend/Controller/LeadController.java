package com.smartlead.backend.Controller;


import com.smartlead.backend.Entity.Lead;
import com.smartlead.backend.Service.LeadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

    private final LeadService leadService;

    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    @PostMapping
    public ResponseEntity<Lead> createLead(@RequestBody Lead lead) {
        Lead createdLead = leadService.createLead(lead);
        return ResponseEntity.ok(createdLead);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lead> getLead(@PathVariable("id") Long leadId) {
        return leadService.getLeadById(leadId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Lead>> getAllLeads() {
        return ResponseEntity.ok(leadService.getAllLeads());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lead> updateLead(@PathVariable("id") Long leadId, @RequestBody Lead lead) {
        Lead updatedLead = leadService.updateLead(leadId, lead);
        return ResponseEntity.ok(updatedLead);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLead(@PathVariable("id") Long leadId) {
        leadService.deleteLead(leadId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/deleted")
    public ResponseEntity<List<Lead>> getDeletedLeads() {
        return ResponseEntity.ok(leadService.getAllDeletedLeads());
    }
}