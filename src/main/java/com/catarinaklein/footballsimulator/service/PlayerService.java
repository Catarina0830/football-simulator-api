package com.catarinaklein.footballsimulator.service;

import com.catarinaklein.footballsimulator.model.Player;

public class PlayerService {

/*calcularResultadoDoChute
* aplicarDesgasteDeStamina
* decidirAcao
* */

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
