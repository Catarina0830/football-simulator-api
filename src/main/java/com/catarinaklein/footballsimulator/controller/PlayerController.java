package com.catarinaklein.footballsimulator.controller;

import com.catarinaklein.footballsimulator.model.Player;
import com.catarinaklein.footballsimulator.service.PlayerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService service;


    public PlayerController(PlayerService service){
        this.service = service;
    }

@PostMapping
    public String criarPlayer(){
    Player player = new Player("Chigiri", 80, 60, 90, 100);

    service.criarPlayer(player);

    return "Player criado!";
}
}
