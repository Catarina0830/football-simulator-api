package com.catarinaklein.footballsimulator.repository;

import com.catarinaklein.footballsimulator.model.Player;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


@Repository
public class PlayerRepository {


    public void deletarPlayer(int id){
        System.out.println("Deletando player com id: " + id);
    }

    public List<Player> listarPlayers(){
        return new ArrayList<>();
    }

    public void salvarPlayer(Player player){


        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test",
                    "root",
                    "1234"
            );

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


            stmt.close();
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    }

