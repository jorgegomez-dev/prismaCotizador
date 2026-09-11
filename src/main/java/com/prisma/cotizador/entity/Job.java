package com.prisma.cotizador.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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
    private boolean isAdvance; // If it is already advance, can be able to "in process status" in jobStatus
    private boolean isPaid; // If it is already paid, can be able to complete pickUpStatus

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Job job = (Job) o;
        return getId() != null && Objects.equals(getId(), job.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
