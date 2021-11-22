package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.entity.Player;
import com.maplr.testhockeygame.entity.Team;
import org.springframework.stereotype.Service;

@Service
public interface HockeyService {

    Team getTeamComposition(Long year);

    Player addPlayer(Player player, Long year);

    Player updateCaptain(Long idPlayer, Long year);
}
