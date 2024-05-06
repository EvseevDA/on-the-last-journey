package ru.onthelastjourney.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "affilation_types")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class AffilationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "category")
    private String category;

    @Column(name = "description")
    private String description;
}
