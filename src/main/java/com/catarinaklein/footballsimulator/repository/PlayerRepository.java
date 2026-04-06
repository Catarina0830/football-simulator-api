package com.catarinaklein.footballsimulator.repository;

import com.catarinaklein.footballsimulator.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {}

