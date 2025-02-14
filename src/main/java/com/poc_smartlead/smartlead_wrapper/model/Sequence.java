package com.poc_smartlead.smartlead_wrapper.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.sql.Timestamp;

@Entity
@Table(name = "sequences")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sequence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Template ID is mandatory")
    private String templateId;

    @NotBlank(message = "Follow-up Email ID is mandatory")
    private String followUpEmailId;

    @Positive(message = "Duration must be positive")
    private int duration;

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