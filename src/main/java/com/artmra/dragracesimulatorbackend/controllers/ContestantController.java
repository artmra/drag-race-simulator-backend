/* (C)2023 */
package com.artmra.dragracesimulatorbackend.controllers;

import com.artmra.dragracesimulatorbackend.persistence.entities.ContestantEntity;
import com.artmra.dragracesimulatorbackend.dto.requests.ContestantsCreationRequest;
import com.artmra.dragracesimulatorbackend.services.ContestantService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contestant")
public class ContestantController {
    private final ContestantService contestantService;

    public ContestantController(ContestantService contestantService) {
        this.contestantService = contestantService;
    }

    @PostMapping("/")
    public List<ContestantEntity> createContestants(
            @RequestBody ContestantsCreationRequest contestantsCreationRequest) {
        return contestantService.createContestants(contestantsCreationRequest);
    }

    @GetMapping("/")
    public boolean getContestant() {
        return false;
    }
}
