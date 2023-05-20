package com.artmra.dragracesimulatorbackend.persistence.repositories;

import com.artmra.dragracesimulatorbackend.persistence.entities.LipSyncEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LipSyncRepository extends JpaRepository<LipSyncEntity, Long> {
}
