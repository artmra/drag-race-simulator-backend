/* (C)2023 */
package com.artmra.dragracesimulatorbackend.services;

import com.artmra.dragracesimulatorbackend.persistence.entities.HausEntity;
import com.artmra.dragracesimulatorbackend.dto.requests.HausInfo;
import com.artmra.dragracesimulatorbackend.persistence.repositories.HausRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HausService {
    private final HausRepository hausRepository;

    public HausService(HausRepository hausRepository) {
        this.hausRepository = hausRepository;
    }

    public HausEntity createHaus(HausInfo hausInfo) {
        Optional<HausEntity> byName = hausRepository.findByName(hausInfo.getName());
        return byName.orElseGet(
                () -> {
                    HausEntity haus = new HausEntity();
                    haus.setName(hausInfo.getName());
                    return hausRepository.save(haus);
                });
    }
}
