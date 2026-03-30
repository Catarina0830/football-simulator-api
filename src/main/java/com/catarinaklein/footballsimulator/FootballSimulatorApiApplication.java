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


		// objeto do model Player criado
		// player Chigiri criado!!

		Player player = new Player("Chigiri", 80, 60, 90, 100);

		// 🔴 conexao com banco
		PlayerRepository repository = new PlayerRepository();
		repository.salvarPlayer(player);


		// 🔴 lógica do service
		System.out.println("Simulando jogo...");

		int opponentDefense = 70;

		PlayerService service = new PlayerService(repository);
		service.calcularResultadoDoChute(player, opponentDefense);
		service.aplicarDesgasteDeStamina(player);
		service.decidirAcao(player);

		System.out.println("Fim da execução.");
	}


}
