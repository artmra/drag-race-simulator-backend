/* (C)2023 */
package com.artmra.dragracesimulatorbackend.persistence.repositories;

import com.artmra.dragracesimulatorbackend.persistence.entities.HausEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HausRepository extends JpaRepository<HausEntity, Long> {
    boolean existsByName(String name);

    Optional<HausEntity> findByName(String name);
}
