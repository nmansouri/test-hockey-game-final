package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.entity.Player;
import com.maplr.testhockeygame.entity.Team;

public interface HockeyService {

    Team getTeamComposition(Long year);

    Player addPlayer(Player player, Long year);

    Player updateCaptain(Long idPlayer, Long year);
}
