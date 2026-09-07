package com.prisma.cotizador.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Quotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idClient;
    private Long idUser;

    private BigDecimal totalPrice;
    private Instant dateTimeQuote;  //Tracking the local date and time when the quote was made

    private boolean isConfirmed;
    private Instant dataTimeConfirmed; //Tracking the local date and time when the User save the confirmation of Client

}
