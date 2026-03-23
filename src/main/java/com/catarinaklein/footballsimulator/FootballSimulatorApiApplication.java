package com.catarinaklein.footballsimulator;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


@SpringBootApplication
public class FootballSimulatorApiApplication {


	public static void main(String[] args) {SpringApplication.run(FootballSimulatorApiApplication.class, args);


		// 🔴 SRP QUEBRADO: A main faz TUDO (lógica, banco, regra, output)
		String playerName = "Isagi";
		int shoot = 80;
		int defense = 60;
		int stamina = 100;


		// 🔴 DIP QUEBRADO: conexão direta com banco (alto acoplamento)
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test",
					"root",
					"1234"
			);


			// 🔴 SRP + OCP QUEBRADOS: SQL direto dentro da lógica
			PreparedStatement stmt = conn.prepareStatement(
					"INSERT INTO player (name, shoot, defense, stamina) VALUES (?, ?, ?, ?)"
			);


			stmt.setString(1, playerName);
			stmt.setInt(2, shoot);
			stmt.setInt(3, defense);
			stmt.setInt(4, stamina);


			stmt.executeUpdate();


			System.out.println("Jogador salvo no banco!");


		} catch (Exception e) {
			e.printStackTrace();
		}


		// 🔴 SRP QUEBRADO: lógica de jogo misturada com tudo
		System.out.println("Simulando jogo...");


		int opponentDefense = 70;


		// 🔴 OCP QUEBRADO: if gigante (não extensível)
		if (shoot > opponentDefense) {
			System.out.println(playerName + " fez um gol!");
		} else {
			System.out.println(playerName + " perdeu a chance!");
		}


		// 🔴 SRP QUEBRADO: regra de negócio + manipulação de estado
		stamina -= 10;


		// 🔴 LSP QUEBRADO (conceitual): não existe abstração de Player, tudo primitivo
		if (stamina <= 0) {
			System.out.println(playerName + " está cansado!");
		}


		// 🔴 ISP QUEBRADO: não existe separação de responsabilidades (tudo depende de tudo)


		// 🔴 DIP QUEBRADO novamente: lógica depende de implementação concreta
		String action;


		if (shoot > 75) {
			action = "CHUTE";
		} else {
			action = "PASSE";
		}


		// 🔴 SRP QUEBRADO: lógica + output juntos
		System.out.println("Ação escolhida: " + action);


		// 🔴 OCP QUEBRADO: adicionar nova ação = editar esse código
		if (action.equals("CHUTE")) {
			System.out.println("Finalizando...");
		} else {
			System.out.println("Tocando a bola...");
		}


		System.out.println("Fim da execução.");
	}


}
