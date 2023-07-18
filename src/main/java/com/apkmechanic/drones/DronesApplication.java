package com.apkmechanic.drones;

import com.apkmechanic.drones.models.Drone;
import com.apkmechanic.drones.models.Model;
import com.apkmechanic.drones.models.State;
import com.apkmechanic.drones.repo.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DronesApplication  implements CommandLineRunner {

	@Autowired
	private DroneRepository droneRepository;

	public static void main(String[] args) {
		SpringApplication.run(DronesApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Drone drone1 = new Drone();
		drone1.setSerialNumber("APKMECHANIC1236");
		drone1.setBatteryLevel(50);
		drone1.setModel(Model.Cruiserweight);
		drone1.setState(State.IDLE);
		droneRepository.save(drone1);

		Drone drone2 = new Drone();
		drone2.setSerialNumber("APKMECHANIC12355");
		drone2.setBatteryLevel(24);
		drone2.setModel(Model.Cruiserweight);
		drone2.setState(State.IDLE);
		droneRepository.save(drone2);

		Drone drone3 = new Drone();
		drone3.setSerialNumber("APKMECHANIC1235");
		drone3.setBatteryLevel(24);
		drone3.setModel(Model.Lightweight);
		drone3.setState(State.RETURNING);
		droneRepository.save(drone3);

		Drone drone4 = new Drone();
		drone4.setSerialNumber("APKMECHANIC12389");
		drone4.setBatteryLevel(60);
		drone4.setModel(Model.Lightweight);
		drone4.setState(State.DELIVERED);
		droneRepository.save(drone4);

	}
}
