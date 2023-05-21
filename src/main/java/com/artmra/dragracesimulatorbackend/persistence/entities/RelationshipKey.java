package com.artmra.dragracesimulatorbackend.persistence.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
public class RelationshipKey implements Serializable {
    @Getter
    @Setter
    @Column(name = "contestant_a_id")
    Long contestantAId;

    @Getter
    @Setter
    @Column(name = "contestant_b_id")
    Long contestantBId;

}
