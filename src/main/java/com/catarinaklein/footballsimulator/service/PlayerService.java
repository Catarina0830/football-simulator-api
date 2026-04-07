package com.catarinaklein.footballsimulator.service;

import com.catarinaklein.footballsimulator.model.Player;
import com.catarinaklein.footballsimulator.repository.PlayerRepository;
import com.catarinaklein.footballsimulator.requestDTO.PlayerRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository repository;

    public PlayerService(PlayerRepository repository){

        this.repository = repository;
    }


    public List<Player> listarPlayers(){
        return repository.findAll();
    }


    public void deletarPlayer(int id){
        repository.deleteById(id);
    }


    public void criarPlayer(PlayerRequestDTO dto){

        Player player = new Player(
                dto.name(),
                dto.shoot(),
                dto.defense(),
                dto.speed(),
                dto.stamina()
        );

        repository.save(player);
    }


    public void atualizarPlayer(int id, PlayerRequestDTO dto){

        Player existente = repository.findById(id)
                .orElseThrow();

        existente.setName(dto.name());
        existente.setShoot(dto.shoot());
        existente.setDefense(dto.defense());
        existente.setSpeed(dto.speed());
        existente.setStamina(dto.stamina());

        repository.save(existente);
    }


/*calcularResultadoDoChute*/

    public void calcularResultadoDoChute(Player player, int opponentDefense){


        if (player.getSpeed() >85 && player.getShoot() > opponentDefense) {
            System.out.println(player.getName() + " fez um gol rápido!");
        } else if (player.getShoot() > opponentDefense) {
            System.out.println(player.getName() + " fez um gol!");
        } else {
            System.out.println(player.getName() + " perdeu a chance!");
        }
    }

/*aplicarDesgasteDeStamina*/

    public void aplicarDesgasteDeStamina(Player player){

        if(player.getSpeed() >80){
            player.setStamina(player.getStamina() - 15);
            System.out.println(player.getName() + " correu muito rápido e cansou mais");
        } else{
            player.setStamina(player.getStamina() - 10);
        }

        if (player.getStamina() <= 0) {
            System.out.println(player.getName() + " está cansado!");
        } else if (player.getStamina() < 30) {
            player.setStamina(player.getStamina() -10);
        }

    }

/*decidirAcao*/

    public void decidirAcao(Player player){

        String action; //isso deveria ser um parâmetro?

        if (player.getShoot() > 75) {
            action = "CHUTE";
        } else {
            action = "PASSE";
        }

        System.out.println("Ação escolhida: " + action);


        if (action.equals("CHUTE")) {
            System.out.println("Finalizando...");
        } else {
            System.out.println("Tocando a bola...");
        }
    }

}
