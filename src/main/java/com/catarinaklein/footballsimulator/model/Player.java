package com.catarinaklein.footballsimulator.model;

public class Player {

   private String name; //originalmente estava playerName na main, o padrão agora é name
   private int shoot;
   private int defense;
   private int speed;
   private int stamina;


   public Player(
           String name,
           int shoot,
           int defense,
           int speed,
           int stamina
   ){

            this.name = name;
            this.shoot = shoot;
            this.defense = defense;
            this.speed = speed;
            this.stamina = stamina;
   }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShoot() {
        return shoot;
    }

    public void setShoot(int shoot) {
        this.shoot = shoot;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
}
