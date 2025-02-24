package com.smartlead.backend.Respository;


import com.smartlead.backend.Entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
    Optional<Lead> findByLeadIdAndDeletedAtIsNull(Long leadId);
    List<Lead> findAllByDeletedAtIsNull();
    List<Lead> findAllByDeletedAtIsNotNull();
}
