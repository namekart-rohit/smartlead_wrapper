package com.smartlead.backend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "contacts")
@Getter
@Setter
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;

    @ManyToOne
    @JoinColumn(name = "lead_id",nullable = true)
    @JsonBackReference
    private Lead lead;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(length = 255, unique = true)
    private String email;

    @Column(length = 20)
    private String phone;

    @Column(length = 100)
    private String position;

    private Boolean isPrimary;

//    @Enumerated(EnumType.STRING)
//    private PreferredContactMethod preferredContactMethod;

    private LocalDateTime lastContactedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    // Getters and Setters
    // For brevity, only showing the setter for deletedAt
    private LocalDateTime deletedAt;

    // Other getters and setters are omitted for brevity
}