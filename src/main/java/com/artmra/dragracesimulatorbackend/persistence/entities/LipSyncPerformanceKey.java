package com.artmra.dragracesimulatorbackend.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
public class LipSyncPerformanceKey implements Serializable {
    @Getter
    @Setter
    @Column(name = "lip_sync_id")
    private Long lipSyncId;

    @Getter
    @Setter
    @Column(name = "contestant_id")
    private Long contestantId;
}
