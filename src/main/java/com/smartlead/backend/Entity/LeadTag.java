package com.smartlead.backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "lead_tags")
public class LeadTag {
    @EmbeddedId
    private LeadTagId id;

    @ManyToOne
    @MapsId("leadId")
    @JoinColumn(name = "lead_id")
    private Lead lead;

    @ManyToOne
    @MapsId("tagId")
    @JoinColumn(name = "tag_id")
    private Tag tag;

    private LocalDateTime taggedAt;

    @Column(length = 50)
    private String taggedBy;
}
