package com.catarinaklein.footballsimulator;


import com.catarinaklein.footballsimulator.model.Player;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


@SpringBootApplication
public class FootballSimulatorApiApplication {

	public static void main(String[] args) {SpringApplication.run(FootballSimulatorApiApplication.class, args);


		// 🔴 SRP QUEBRADO: A main faz TUDO (lógica, banco, regra, output)

		Player player = new Player("Chigiri", 80, 60, 90, 100);

		// 🔴 DIP QUEBRADO: conexão direta com banco (alto acoplamento)
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test",
					"root",
					"1234"
			);


			// 🔴 SRP + OCP QUEBRADOS: SQL direto dentro da lógica
			PreparedStatement stmt = conn.prepareStatement(
					"INSERT INTO player (name, shoot, defense, speed, stamina) VALUES (?, ?, ?, ?, ?)"
			);


			stmt.setString(1, player.getName());
			stmt.setInt(2, player.getShoot());
			stmt.setInt(3, player.getDefense());
			stmt.setInt(4, player.getSpeed());
			stmt.setInt(5, player.getStamina());


			stmt.executeUpdate();


			System.out.println("Jogador salvo no banco!");


		} catch (Exception e) {
			e.printStackTrace();
		}


		// 🔴 SRP QUEBRADO: lógica de jogo misturada com tudo
		System.out.println("Simulando jogo...");


		int opponentDefense = 70;


		// 🔴 OCP QUEBRADO: if gigante (não extensível)
		if (player.getSpeed() >85 && player.getShoot() > opponentDefense) {
			System.out.println(player.getName() + " fez um gol rápido!");
		} else if (player.getShoot() > opponentDefense) {
			System.out.println(player.getName() + " fez um gol!");
		} else {
			System.out.println(player.getName() + " perdeu a chance!");
		}


		// 🔴 SRP QUEBRADO: regra de negócio + manipulação de estado

		if(player.getSpeed() >80){
			player.setStamina(player.getStamina() - 15);
			System.out.println(player.getName() + " correu muito rápido e cansou mais");
		} else{
			player.setStamina(player.getStamina() - 10);
		}


		// 🔴 LSP QUEBRADO (conceitual): não existe abstração de Player, tudo primitivo
		if (player.getStamina() <= 0) {
			System.out.println(player.getName() + " está cansado!");
		} else if (player.getStamina() < 30) {
			player.setStamina(player.getStamina() -10);
		}


		// 🔴 ISP QUEBRADO: não existe separação de responsabilidades (tudo depende de tudo)


		// 🔴 DIP QUEBRADO novamente: lógica depende de implementação concreta
		String action;


		if (player.getShoot() > 75) {
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
