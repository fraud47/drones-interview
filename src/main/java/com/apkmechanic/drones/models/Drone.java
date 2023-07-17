package com.apkmechanic.drones.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @author Fraud47
 * @project drones
 * @website www.apkmechanic.co.zw
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "drones",uniqueConstraints = {@UniqueConstraint(columnNames = {"serialNumber"})})
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serialNumber;
    private int batteryLevel;
    @Enumerated(EnumType.STRING)
    private Model model;
    @Enumerated(EnumType.STRING)
    private  State state;
    @OneToMany(mappedBy = "drone",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Medicine> medicines;
}
