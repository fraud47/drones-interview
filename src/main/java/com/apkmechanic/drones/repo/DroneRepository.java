package com.apkmechanic.drones.repo;
import java.util.List;
import java.util.Optional;
import com.apkmechanic.drones.models.Drone;
import com.apkmechanic.drones.models.State;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Fraud47
 * @project drones
 * @website www.apkmechanic.co.zw
 */
 public interface DroneRepository extends JpaRepository<Drone,Long> {
        Optional<Drone> findById(Long id);
        List<Drone> findByState(State state);
        }