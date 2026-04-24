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
    service.criar(dto);

    return "Player criado!";
}


@GetMapping
public List<Player> listar(){
        return service.listarTodos();
    }


@DeleteMapping("/{id}")
public String deletar(@PathVariable int id){
        service.deletar(id);
        return "Player deletado!";
}

@PutMapping("/{id}")
    public String atualizar(@PathVariable int id,
                            @RequestBody PlayerRequestDTO dto){
        service.atualizar(id, dto);
        return "Player atualizado!";
}
}
