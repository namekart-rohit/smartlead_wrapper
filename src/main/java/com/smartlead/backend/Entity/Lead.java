package com.smartlead.backend.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "leads")
@Setter
@Getter
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadId;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(name = "company_name", length = 100)
    private String companyName;

    @Column(name = "interested_domain", length = 200)
    private String interestedDomain;

    @Column(precision = 10, scale = 2)
    private BigDecimal budget;

//    @Enumerated(EnumType.STRING)
//    private LeadStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    // Getters and Setters
    // For brevity, only showing the setter for deletedAt
    @Setter
    private LocalDateTime deletedAt;

    @Column(length = 50)
    private String source;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 255)
    private String website;

    @Column(length = 100)
    private String industry;

    private LocalDateTime nextFollowUp;

    @OneToMany(mappedBy = "lead", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Contact> contacts;

}