package com.poc_smartlead.smartlead_wrapper.repository;

import com.poc_smartlead.smartlead_wrapper.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
} 