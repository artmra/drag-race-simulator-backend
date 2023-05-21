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
    @EmbeddedId
    @Getter
    @Setter
    private RelationshipKey id;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private RelationshipTypeEnum relationshipType;

    @Getter
    @Setter
    @ManyToOne
    @MapsId("contestantAId")
    @JoinColumn(name = "contestant_a_id")
    private ContestantEntity contestantA;

    @Getter
    @Setter
    @ManyToOne
    @MapsId("contestantBId")
    @JoinColumn(name = "contestant_b_id")
    private ContestantEntity contestantB;
}
