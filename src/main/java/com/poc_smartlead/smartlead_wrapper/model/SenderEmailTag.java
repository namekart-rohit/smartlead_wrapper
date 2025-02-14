package com.poc_smartlead.smartlead_wrapper.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "sender_email_tags")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SenderEmailTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tag name is mandatory")
    private String tagName;

    @NotBlank(message = "Sender Email ID is mandatory")
    private String senderEmailId;
} 