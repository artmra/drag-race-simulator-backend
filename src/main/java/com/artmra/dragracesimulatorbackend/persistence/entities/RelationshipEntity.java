/* (C)2023 */
package com.artmra.dragracesimulatorbackend.persistence.entities;

import com.artmra.dragracesimulatorbackend.enums.RelationshipTypeEnum;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "relationship")
public class RelationshipEntity {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private RelationshipTypeEnum relationshipType;

    @Getter
    @Setter
    @ManyToMany
    @JoinTable(
            name = "contestant_relationship",
            joinColumns = @JoinColumn(name = "contestant_id"),
            inverseJoinColumns = @JoinColumn(name = "relationship_id"))
    private Set<ContestantEntity> connectedContestants;
}
