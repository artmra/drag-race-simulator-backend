/* (C)2023 */
package com.artmra.dragracesimulatorbackend.persistence.repositories;

import com.artmra.dragracesimulatorbackend.persistence.entities.SeasonEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<SeasonEntity, Long> {}
