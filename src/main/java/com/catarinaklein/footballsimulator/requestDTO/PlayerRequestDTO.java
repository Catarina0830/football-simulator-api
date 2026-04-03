package com.catarinaklein.footballsimulator.requestDTO;

public record PlayerRequestDTO (String name,
                                int shoot,
                                int defense,
                                int speed,
                                int stamina
){}
