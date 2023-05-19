/* (C)2023 */
package com.artmra.dragracesimulatorbackend.persistence.repositories;

import com.artmra.dragracesimulatorbackend.persistence.entities.RelationshipEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationshipRepository extends JpaRepository<RelationshipEntity, Long> {}
