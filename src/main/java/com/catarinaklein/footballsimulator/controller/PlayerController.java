package com.catarinaklein.footballsimulator.controller;

import com.catarinaklein.footballsimulator.model.Player;
import com.catarinaklein.footballsimulator.requestDTO.PlayerRequestDTO;
import com.catarinaklein.footballsimulator.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService service;


    public PlayerController(PlayerService service){
        this.service = service;
    }

@PostMapping
    public String criarPlayer(@RequestBody PlayerRequestDTO dto){
    service.criarPlayer(dto);

    return "Player criado!";
}


@GetMapping
public List<Player> listar(){
        return service.listarPlayers();
    }


@DeleteMapping("/{id}")
public String deletar(@PathVariable int id){
        service.deletarPlayer(id);
        return "Player deletado!";
}

@PutMapping("/{id}")
    public String atualizar(@PathVariable int id,
                            @RequestBody PlayerRequestDTO dto){
        service.atualizarPlayer(id, dto);
        return "Player atualizado!";
}
}
