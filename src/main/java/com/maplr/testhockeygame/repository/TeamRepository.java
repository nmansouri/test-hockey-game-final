package com.maplr.testhockeygame.repository;

import com.maplr.testhockeygame.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    /**
     * Récupère une équipe en fonction de l'année en pramètre.
     */
    @Query("SELECT t FROM Team t WHERE t.year = :year")
    Team findTeamByYear(@Param("year") Long year);
}
