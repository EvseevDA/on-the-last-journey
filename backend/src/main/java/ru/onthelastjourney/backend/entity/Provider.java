package ru.onthelastjourney.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "providers")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "speak_to")
    private String speakTo;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "country")
    private String country;

    @Column(name = "region")
    private String region;

    @Column(name = "city")
    private String city;

    @Column(name = "index")
    private String index;

    @Column(name = "phone_number")
    private String phoneNumber;
}
