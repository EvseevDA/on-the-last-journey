package ru.onthelastjourney.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "funeral_affilations")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class FuneralAffilation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(
            targetEntity = Provider.class,
            cascade = CascadeType.MERGE
    )
    @JoinColumn(name = "provider_id", referencedColumnName = "id")
    private Provider provider;

    @ManyToOne(
            targetEntity = AffilationType.class,
            cascade = CascadeType.MERGE
    )
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private AffilationType affilationType;

    @Column(name = "unit")
    private String unit;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "in_storage")
    private Long inStorage;

    @Column(name = "expected")
    private Long expected;

    @Column(name = "supplies_stopped")
    private Boolean suppliesStopped;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
