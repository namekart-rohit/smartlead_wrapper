package com.poc_smartlead.smartlead_wrapper.controller;

import com.poc_smartlead.smartlead_wrapper.model.Campaign;
import com.poc_smartlead.smartlead_wrapper.service.CampaignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {

    private static final Logger logger = LoggerFactory.getLogger(CampaignController.class);

    private final CampaignService campaignService;

    @Autowired
    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping("/")
    public List<Campaign> getAllCampaigns() {
        logger.info("Fetching all campaigns");
        return campaignService.getAllCampaigns();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campaign> getCampaignById(@PathVariable Long id) {
        logger.info("Fetching campaign with id: {}", id);
        Campaign campaign = campaignService.getCampaignById(id);
        return campaign != null ? ResponseEntity.ok(campaign) : ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public Campaign createCampaign(@Valid @RequestBody Campaign campaign) {
        logger.info("Creating new campaign");
        return campaignService.saveCampaign(campaign);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCampaign(@PathVariable Long id) {
        logger.info("Deleting campaign with id: {}", id);
        campaignService.deleteCampaign(id);
        return ResponseEntity.noContent().build();
    }
} 