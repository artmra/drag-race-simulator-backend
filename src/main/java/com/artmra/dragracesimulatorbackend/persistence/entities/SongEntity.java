package com.artmra.dragracesimulatorbackend.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "song")
public class SongEntity {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String artist;

    @Getter
    @Setter
    @Column(columnDefinition = "boolean default false")
    private boolean alreadyUsed;

    @Getter
    @Setter
    @OneToMany(mappedBy = "song")
    private Set<LipSyncEntity> featuredLipSyncs;
}
