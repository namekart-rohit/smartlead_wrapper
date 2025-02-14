package com.poc_smartlead.smartlead_wrapper.repository;

import com.poc_smartlead.smartlead_wrapper.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadRepository extends JpaRepository<Lead, String> {
} 