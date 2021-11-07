package com.maplr.testhockeygame.entity;


import com.maplr.testhockeygame.enumeration.Position;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="Player")
public class Player implements Serializable {

    /*
     * Numéro d'identification.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /*
     * Numéro du joueur.
     */
    @Column(nullable = false, length=5)
    private Long number;

    /*
     * Prénom du joueur.
     */
    @Column(nullable = false, length=50)
    private String name;

    /*
     * Nom du joueur.
     */
    @Column(nullable = false, length=50)
    private String lastname;

    /*
     * Position dans le jeu.
     */
    @Enumerated(EnumType.STRING)
    private Position position;

    /*
     * Indicateur du capitaine d'équipe.
     */
    @Column(nullable = false)
    private boolean isCaptain;

    /*
     * Indicateur du capitaine d'équipe.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;


    // Constructeur
    public Player() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isCaptain() {
        return isCaptain;
    }

    public void setCaptain(boolean captain) {
        isCaptain = captain;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
