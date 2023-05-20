/* (C)2023 */
package com.artmra.dragracesimulatorbackend.persistence.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Entity
@Table(name = "contestant")
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class ContestantEntity {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter private String name;

    @Getter
    @Setter
    @Column(unique = true)
    private String dragName;

    @Getter @Setter private int actingScore;

    @Getter @Setter private int comedyScore;

    @Getter @Setter private int danceScore;

    @Getter @Setter private int designScore;

    @Getter @Setter private int improvScore;

    @Getter @Setter private int runwayScore;

    @Getter @Setter private int lipSyncScore;

    // ligacao com casa
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "haus_id", nullable = true)
    private HausEntity haus;

    // participantes com os quais possui alguma relação
    @Getter
    @Setter
    @ManyToMany(mappedBy = "connectedContestants")
    private Set<RelationshipEntity> relationships;

    // ligacao com temporadas
    @Getter
    @Setter
    @ManyToMany(mappedBy = "seasonContestants")
    private Set<SeasonEntity> staredSeasons;

    // ligacao com lipsyncs
    @Getter
    @Setter
    @OneToMany(mappedBy = "contestant")
    private Set<LipSyncPerformanceEntity> lipSyncPerformances;

    // ligacao com challenges

    // ganhadora
    @Getter
    @Setter
    @Column(columnDefinition = "boolean default false")
    private boolean winner;
}
