package com.poc_smartlead.smartlead_wrapper.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "schedules")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    @Id
    private String id;
    private String timezone;
    private String dailyDuration;
    private String days;
} 