/* (C)2023 */
package com.artmra.dragracesimulatorbackend.persistence.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "reality_show")
public class RealityShowEntity {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(unique = true)
    private String name;

    @Getter
    @Setter
    @OneToMany(mappedBy = "realityShow")
    private Set<SeasonEntity> seasons;
}
