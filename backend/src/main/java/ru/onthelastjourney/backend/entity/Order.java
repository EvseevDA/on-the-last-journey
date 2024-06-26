package ru.onthelastjourney.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(
            targetEntity = Client.class,
            cascade = CascadeType.MERGE
    )
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "appointment_date")
    private LocalDateTime appointmentDate;

    @Column(name = "execution_date")
    private LocalDateTime executionDate;
}
