/* (C)2023 */
package com.artmra.dragracesimulatorbackend.persistence.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "haus")
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class HausEntity {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(unique = true)
    private String name;

    @Getter
    @Setter
    @OneToMany(mappedBy = "haus")
//    @JoinTable(
//            name = "contestants_hauses",
//            joinColumns = @JoinColumn(name = "contestant_id"),
//            inverseJoinColumns = @JoinColumn(name = "haus_id"))
    private Set<ContestantEntity> members;
}
