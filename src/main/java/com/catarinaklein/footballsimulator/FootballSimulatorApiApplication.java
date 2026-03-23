package com.catarinaklein.footballsimulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@SpringBootApplication
public class FootballSimulatorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballSimulatorApiApplication.class, args);

	}

}
