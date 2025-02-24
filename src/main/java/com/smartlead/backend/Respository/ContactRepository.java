package com.smartlead.backend.Respository;


import com.smartlead.backend.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Optional<Contact> findByContactIdAndDeletedAtIsNull(Long contactId);
    List<Contact> findAllByDeletedAtIsNull();
    List<Contact> findByLead_LeadIdAndDeletedAtIsNull(Long leadId);
    List<Contact> findAllByDeletedAtIsNotNull();
}
