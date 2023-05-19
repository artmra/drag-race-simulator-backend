/* (C)2023 */
package com.artmra.dragracesimulatorbackend.services;

import com.artmra.dragracesimulatorbackend.dto.requests.ContestantInfo;
import com.artmra.dragracesimulatorbackend.dto.requests.ContestantsCreationRequest;
import com.artmra.dragracesimulatorbackend.persistence.entities.ContestantEntity;
import com.artmra.dragracesimulatorbackend.persistence.repositories.ContestantRepository;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ContestantService {
    private final ContestantRepository contestantRepository;
    private final HausService hausService;

    public ContestantService(ContestantRepository contestantRepository, HausService hausService) {
        this.contestantRepository = contestantRepository;
        this.hausService = hausService;
    }

    public List<ContestantEntity> createContestants(
            ContestantsCreationRequest contestantsCreationRequest) {
        return contestantsCreationRequest.getContestants().stream()
                .map(this::getOrCreateContestant)
                .collect(Collectors.toList());
    }

    private ContestantEntity getOrCreateContestant(ContestantInfo contestantInfo) {
        Optional<ContestantEntity> byDragName =
                contestantRepository.findByDragName(contestantInfo.getDragName());
        return byDragName.orElseGet(() -> createContestant(contestantInfo));
    }

    private ContestantEntity createContestant(ContestantInfo contestantInfo) {
        final Random random = new Random();
        // generate score
        int scoreModifier = random.nextInt(35, 40);
        // default values
        List<Integer> defaultValues = new ArrayList<>(Collections.nCopies(7, 5));
        while (scoreModifier > 0) {
            var iterator = defaultValues.listIterator();
            while (iterator.hasNext()) {
                int actualAttrValue = iterator.next();
                if (scoreModifier > 0 && actualAttrValue < 15) {
                    var attrUpdateValue = getAttrUpdateValue(scoreModifier, actualAttrValue);
                    iterator.set(actualAttrValue + attrUpdateValue);
                    scoreModifier = scoreModifier - attrUpdateValue;
                }
            }
        }
        ContestantEntity contestant = new ContestantEntity();
        contestant.setName(contestantInfo.getName());
        contestant.setDragName(contestantInfo.getDragName());
        contestant.setActingScore(defaultValues.remove(random.nextInt(0, defaultValues.size())));
        contestant.setComedyScore(defaultValues.remove(random.nextInt(0, defaultValues.size())));
        contestant.setDanceScore(defaultValues.remove(random.nextInt(0, defaultValues.size())));
        contestant.setDesignScore(defaultValues.remove(random.nextInt(0, defaultValues.size())));
        contestant.setImprovScore(defaultValues.remove(random.nextInt(0, defaultValues.size())));
        contestant.setRunwayScore(defaultValues.remove(random.nextInt(0, defaultValues.size())));
        contestant.setLipSyncScore(defaultValues.remove(0));
        if (Objects.nonNull(contestantInfo.getHaus()))
            contestant.setHaus(hausService.createHaus(contestantInfo.getHaus()));
        return contestantRepository.save(contestant);
    }

    private int getAttrUpdateValue(int scoreModifier, int actualAttrValue) {
        // calcular em quanto o atributo ainda pode ser atualizado
        int attrDifference = 15 - actualAttrValue;
        // se difference ou scoreModifier == 1 retorna 1
        if (scoreModifier == 1 || attrDifference == 1) return 1;
        // se difference > 1, updateValue deve estar entre [1,difference]
        // se scoreModifier < difference, o updateValue deve estar entre [1, scoreModifier]
        int upperBond = Math.min(scoreModifier, attrDifference);
        upperBond = Math.min(upperBond, 5);
        // soma +1 a upperBond pois o intervalo gerado pelo método é exclusivo
        return new Random().nextInt(0, upperBond + 1);
    }
}
