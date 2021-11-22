package com.maplr.testhockeygame.controller;

import com.maplr.testhockeygame.entity.Player;
import com.maplr.testhockeygame.entity.Team;
import com.maplr.testhockeygame.service.HockeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class HockeyController  {

    private final HockeyService hockeyService;


    // Constructeur
    @Autowired
    public HockeyController(HockeyService hockeyService) {
        this.hockeyService = hockeyService;
    }


    /**
     * Récupère la composition de l'équipe de hockey en fonction de l'année en paramètre.
     *
     * @param year year
     * @return Team
     */
    @RequestMapping(produces = "application/json", value = "/team/{year}", method = RequestMethod.GET)
    public Team getTeamComposition(@PathVariable Long year) {
        return this.hockeyService.getTeamComposition(year);
    }


    /**
     * Ajoute un membre à l'équipe pour une année définie en paramètre.
     *
     * @param player player
     * @param year year
     * @return Player
     */
    @RequestMapping(produces = "application/json", value = "/team/addPlayer/{year}",
                    method = {RequestMethod.POST, RequestMethod.GET})
    public Player addPlayer(@RequestBody Player player, @PathVariable Long year){
        return this.hockeyService.addPlayer(player, year);
    }


    /**
     * Met à jour le capitaine d'une équipe pour une année définie.
     *
     * @param idPlayer idPlayer
     * @return Player
     */
    @RequestMapping(produces = "application/json", value = "/player/captain/{idPlayer}",
                    method = {RequestMethod.PUT, RequestMethod.GET})
    public Player updateCaptain(@PathVariable Long idPlayer){
        return this.hockeyService.updateCaptain(idPlayer, 2020L);
    }
}
