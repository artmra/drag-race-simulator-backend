/* (C)2023 */
package com.artmra.dragracesimulatorbackend.persistence.repositories;

import com.artmra.dragracesimulatorbackend.persistence.entities.ContestantEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ContestantRepository extends JpaRepository<ContestantEntity, Long> {
    Optional<ContestantEntity> findByDragName(String dragName);

    List<ContestantEntity> findAllByDragNameIn(Collection<String> dragNames);
}
