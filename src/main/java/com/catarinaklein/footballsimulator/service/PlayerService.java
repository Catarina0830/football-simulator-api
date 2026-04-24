package com.catarinaklein.footballsimulator.service;

import jakarta.persistence.EntityNotFoundException;
import com.catarinaklein.footballsimulator.strategy.PlayerAction;
import com.catarinaklein.footballsimulator.model.Player;
import com.catarinaklein.footballsimulator.repository.PlayerRepository;
import com.catarinaklein.footballsimulator.requestDTO.PlayerRequestDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository repository;
    private final List<PlayerAction> acoes;

    public PlayerService(PlayerRepository repository, List<PlayerAction> acoes) {
        this.repository = repository;
        this.acoes = acoes;
    }

    // --- MÉTODOS DE BANCO DE DADOS ---
    public List<Player> listarTodos() {
        return repository.findAll();
    }

    public void criar(PlayerRequestDTO dto) {
        Player player = new Player(dto.name(), dto.shoot(), dto.defense(), dto.speed(), dto.stamina());
        repository.save(player);
    }

    public void deletar(int id) {
        repository.deleteById(id);
    }

    public void atualizar(Integer id, PlayerRequestDTO dto) {
        Player p = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        p.setName(dto.name());
        p.setShoot(dto.shoot());
        p.setDefense(dto.defense());
        p.setSpeed(dto.speed());
        p.setStamina(dto.stamina());
        repository.save(p);
    };

    // --- MÉTODOS DE LÓGICA DE JOGO (SOLID) ---
    public void simularAcao(int id) {
        Player player = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        acoes.stream()
                .filter(a -> a.seAplica(player))
                .findFirst()
                .ifPresent(a -> a.executar(player));

        aplicarDesgaste(player);
        repository.save(player);
    }

    private void aplicarDesgaste(Player p) {
        int perda = (p.getSpeed() > 80) ? 15 : 10;
        p.setStamina(Math.max(0, p.getStamina() - perda));
    }
}