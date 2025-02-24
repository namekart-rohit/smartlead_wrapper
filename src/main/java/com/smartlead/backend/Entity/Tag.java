package com.smartlead.backend.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tag")
@Getter
@Setter
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @Column(name = "tagText",length = 50,unique = true,nullable = false)
    private String tagText;

    @Column(length = 7)
    private String color;

    @Column(length = 255)
    private String description;

    private String category;

    @ManyToOne
    @JoinColumn(name = "parent_tag_id")
    private Tag parentTag;

    @Column(name = "is_Active")
    private Boolean isActive;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Column(name = "created_by", length = 50)
    private String createdBy;

    @Column(name = "updated_by", length = 50)
    private String updatedBy;
}
