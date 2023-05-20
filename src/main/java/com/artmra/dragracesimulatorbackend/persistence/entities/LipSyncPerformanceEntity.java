package com.artmra.dragracesimulatorbackend.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "lip_sync_performance")
public class LipSyncPerformanceEntity {
    @EmbeddedId
    @Getter
    @Setter
    private LipSyncPerformanceKey id;

    @Getter
    @Setter
    private boolean victorious;

    @Getter
    @Setter
    @ManyToOne
    @MapsId("lipSyncId")
    @JoinColumn(name = "lip_sync_id")
    private LipSyncEntity lipSync;

    @Getter
    @Setter
    @ManyToOne
    @MapsId("contestantId")
    @JoinColumn(name = "contestant_id")
    private ContestantEntity contestant;
}
