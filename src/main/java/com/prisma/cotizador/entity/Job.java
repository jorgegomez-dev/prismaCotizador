package com.prisma.cotizador.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idClient;
    private Long idQuotation;

    private BigDecimal totalPrice;
    private LocalDateTime deadLine; // Day and hour to will finish the job '2026-08-07 15:30hs'
    private String pickUpOption; // Two options (owner business address and a pickup point)
    private String notes; // Additional information about the job

    private String jobStatus;  // State can be 'in process, finished'
    private String pickUpStatus; // State can be 'in owner address, in pickup point'
    private String paymentStatus; // State can be 'unpaid, advance, paid'
    private String paymentMethod; // Can be 'cash, transfer, debit or credit card'

}
