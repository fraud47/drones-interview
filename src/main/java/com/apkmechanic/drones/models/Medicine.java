package com.apkmechanic.drones.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fraud47
 * @project drones
 * @website www.apkmechanic.co.zw
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private String code;
    private float weight;
    private String image;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drone_id", nullable = false)
    private Drone drone;

}
