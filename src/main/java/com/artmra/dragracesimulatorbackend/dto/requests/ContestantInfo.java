/* (C)2023 */
package com.artmra.dragracesimulatorbackend.dto.requests;

import jakarta.annotation.Nullable;

import lombok.Data;

@Data
public class ContestantInfo {
    private String name;
    private String dragName;
    @Nullable private HausInfo haus;
}
