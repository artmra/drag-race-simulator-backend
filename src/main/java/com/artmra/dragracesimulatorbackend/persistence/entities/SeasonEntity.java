/* (C)2023 */
package com.artmra.dragracesimulatorbackend.persistence.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "season")
public class SeasonEntity {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // programa relacionado
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "reality_show_id", nullable = false)
    private RealityShowEntity realityShow;

    // episodios

    // cast
    @Getter
    @Setter
    @ManyToMany
    @JoinTable(
            name = "season_cast",
            joinColumns = @JoinColumn(name = "contestant_id"),
            inverseJoinColumns = @JoinColumn(name = "season_id"))
    private Set<ContestantEntity> seasonContestants;
}
