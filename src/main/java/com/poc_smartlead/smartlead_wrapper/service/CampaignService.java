package com.poc_smartlead.smartlead_wrapper.service;

import com.poc_smartlead.smartlead_wrapper.model.Campaign;
import com.poc_smartlead.smartlead_wrapper.repository.CampaignRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {

    private static final Logger logger = LoggerFactory.getLogger(CampaignService.class);

    @Autowired
    private CampaignRepository campaignRepository;

    public List<Campaign> getAllCampaigns() {
        logger.info("Retrieving all campaigns");
        return campaignRepository.findAll();
    }

    public Campaign getCampaignById(Long id) {
        logger.info("Retrieving campaign with id: {}", id);
        return campaignRepository.findById(id).orElse(null);
    }

    public Campaign saveCampaign(Campaign campaign) {
        logger.info("Saving campaign with id: {}", campaign.getId());
        return campaignRepository.save(campaign);
    }

    public void deleteCampaign(Long id) {
        logger.info("Deleting campaign with id: {}", id);
        campaignRepository.deleteById(id);
    }
} 