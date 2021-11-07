package com.maplr.testhockeygame.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name="Team")
public class Team implements Serializable {

    /*
     * Numéro d'identification.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /*
     * Nom du coach.
     */
    @Column(nullable = false, length=50)
    private String coach;

    /*
     * Année de participation à la ligue nationale.
     */
    @Column(nullable = false, length=5)
    private Long year;

    /*
     * Liste des joueurs de l'équipe.
     */
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> players;


    // Constructeur
    public Team() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
