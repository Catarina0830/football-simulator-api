package com.catarinaklein.footballsimulator;


import com.catarinaklein.footballsimulator.model.Player;
import com.catarinaklein.footballsimulator.service.PlayerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


@SpringBootApplication
public class FootballSimulatorApiApplication {

	public static void main(String[] args) {SpringApplication.run(FootballSimulatorApiApplication.class, args);


		// objeto do model Player criado
		// player Chigiri criado!!

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


		// 🔴 lógica do service
		System.out.println("Simulando jogo...");

		PlayerService service = new PlayerService();

		int opponentDefense = 70;

		service.calcularResultadoDoChute(player, opponentDefense);
		service.aplicarDesgasteDeStamina(player);
		service.decidirAcao(player);

		System.out.println("Fim da execução.");
	}


}
