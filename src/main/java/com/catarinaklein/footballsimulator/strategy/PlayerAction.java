package com.catarinaklein.footballsimulator.strategy;

import com.catarinaklein.footballsimulator.model.Player;

public interface PlayerAction {

    boolean seAplica(Player player);
    void executar(Player player);
}
