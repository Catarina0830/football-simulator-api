package com.catarinaklein.footballsimulator;


import com.catarinaklein.footballsimulator.model.Player;
import com.catarinaklein.footballsimulator.repository.PlayerRepository;
import com.catarinaklein.footballsimulator.requestDTO.PlayerRequestDTO;
import com.catarinaklein.footballsimulator.service.PlayerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FootballSimulatorApiApplication {

	public static void main(String[] args) {SpringApplication.run(FootballSimulatorApiApplication.class, args);
	}
}
