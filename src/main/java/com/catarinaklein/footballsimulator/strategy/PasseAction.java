package com.catarinaklein.footballsimulator.strategy;

import com.catarinaklein.footballsimulator.model.Player;
import org.springframework.stereotype.Component;

@Component
public class PasseAction implements PlayerAction {
    @Override
    public boolean seAplica(Player p) { return p.getShoot() <= 75; }

    @Override
    public void executar(Player p) { System.out.println(p.getName() + " está tocando a bola..."); }
}