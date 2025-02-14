package com.poc_smartlead.smartlead_wrapper.repository;

import com.poc_smartlead.smartlead_wrapper.model.SenderEmail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SenderEmailRepository extends JpaRepository<SenderEmail, String> {
} 