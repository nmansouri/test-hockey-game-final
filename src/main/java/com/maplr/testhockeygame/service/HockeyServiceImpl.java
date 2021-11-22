package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.entity.Player;
import com.maplr.testhockeygame.entity.Team;
import com.maplr.testhockeygame.enumeration.Position;
import com.maplr.testhockeygame.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation de {@link HockeyService}
 */
@Service
public class HockeyServiceImpl implements HockeyService {

    TeamRepository teamRepository;


    // Constructeur
    @Autowired
    public HockeyServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    /**
     * Récupère la composition de l'équipe de hockey en fonction de l'année en paramètre.
     *
     * @param year year
     * @return Team
     */
    @Override
    public Team getTeamComposition(Long year) {
        return this.teamRepository.findTeamByYear(year);
    }


    /**
     * Ajoute un membre à l'équipe pour une année définie.
     *
     * @param player player
     * @param year year
     * @return Player
     */
    @Override
    public Player addPlayer(Player player, Long year) {
        // On récupère l'équipe en fonction de l'année
        Team team = teamRepository.findTeamByYear(year);
        Team savedTeam = new Team();

        if(team != null) {
            // On ajoute le nouveau membre dans la liste des joueurs de l'équipe
            List<Player> players = team.getPlayers();
            players.add(player);

            // On enregistre les modification en base
            savedTeam = this.teamRepository.saveAndFlush(team);
        }

        // On affiche le joueur qui vient d'être ajouté
        return this.playerToReturn(savedTeam, player.getNumber());
    }


    /**
     * Met à jour le capitaine d'une équipe pour une année définie.
     *
     * @param idPlayer idPlayer
     * @param year year
     * @return Player
     */
    @Override
    public Player updateCaptain(Long idPlayer, Long year) {
        // On récupère l'équipe en fonction de l'année
        Team team = teamRepository.findTeamByYear(year);
        Team savedTeam = new Team();

        if(team != null) {
            for(Player player : team.getPlayers()) {
                // On supprime le poste de l'ancien capitaine
                if(player.isCaptain()) {
                    player.setCaptain(false);
                }
                // On ajoute le nouveau capitaine
                if(player.getNumber().equals(idPlayer)) {
                    player.setCaptain(true);
                }
            }
            // On enregistre les modification en base
            savedTeam = this.teamRepository.saveAndFlush(team);
        }

        // On affiche le nouveau capitaine
        return this.playerToReturn(savedTeam, idPlayer);
    }


    /**
     * Récupère le joueur issus de l'action lancé par l'utilisateur (POST/PUT).
     *
     * @param savedTeam savedTeam
     * @param playerNumber playerNumber
     * @return Player
     */
    private Player playerToReturn(Team savedTeam, Long playerNumber) {
        Player finalPlayer = null;

        // On récupère le joueur dans l'équipe
        for(Player player : savedTeam.getPlayers()) {
            if(player.getNumber().equals(playerNumber)) {
                finalPlayer = player;
            }
        }
        return finalPlayer;
    }

}
