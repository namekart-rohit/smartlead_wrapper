package com.poc_smartlead.smartlead_wrapper.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

@Entity
@Table(name = "campaigns")
@Data // Lombok annotation to generate getters and setters
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
@AllArgsConstructor // Lombok annotation to generate an all-argument constructor
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Sequence ID is mandatory")
    private String sequenceId;

    @NotNull(message = "Starting time is mandatory")
    private Timestamp startingTime;

    @NotBlank(message = "Contacts List ID is mandatory")
    private String contactsListId;

    @NotBlank(message = "Sender Email ID is mandatory")
    private String senderEmailId;

    @NotBlank(message = "Schedule ID is mandatory")
    private String scheduleId;

    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    @Column(nullable = false)
    private Timestamp updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = updatedAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }
} 