package com.artmra.dragracesimulatorbackend.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="lip_sync")
public class LipSyncEntity {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // song
    @Getter
    @Setter
    @ManyToOne(optional = false)
    @JoinColumn(name = "song_id")
    private SongEntity song;

    // participantes
    @Getter
    @Setter
    @OneToMany(mappedBy = "lipSync")
    private Set<LipSyncPerformanceEntity> lipSyncPerformances;

}
