package com.service_desc_2.servicedesc2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = 45)
    private String title;

    @Column(name = "description", nullable = false, length = 45)
    private String description;

    @Column(name = "status", nullable = false, length = 45)
    private String status; // Open, In Progress, Done

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee assignedEmployee;
}
