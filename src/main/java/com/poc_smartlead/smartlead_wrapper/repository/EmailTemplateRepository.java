package com.poc_smartlead.smartlead_wrapper.repository;

import com.poc_smartlead.smartlead_wrapper.model.EmailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, String> {
} 