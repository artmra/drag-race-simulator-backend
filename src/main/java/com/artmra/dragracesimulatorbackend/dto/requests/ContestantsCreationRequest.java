/* (C)2023 */
package com.artmra.dragracesimulatorbackend.dto.requests;

import lombok.Data;

import java.util.List;

@Data
public class ContestantsCreationRequest {
    List<ContestantInfo> contestants;
}
