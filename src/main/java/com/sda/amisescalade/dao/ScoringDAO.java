package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.Lenght;
import com.sda.amisescalade.entities.Road;
import com.sda.amisescalade.entities.Scoring;
import com.sda.amisescalade.entities.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ScoringDAO extends JpaRepository <Scoring,Long> {
    @Query("select s from Scoring s left join fetch s.road r where r.sector.id = :idsecteur")
    List<Scoring> findScoringBySectorId(@Param("idsecteur") Long id);

    @Query("select s from Scoring s left join fetch s.road r where r.sector.id = :idsecteur")
    public  Scoring findBySectorId(@Param("idsecteur") Long id);

    @Query("select distinct scoring from Scoring scoring left join fetch scoring.road r")
    public List<Scoring> findDistinctByRoad();

    List<Spot> findById(Optional<Long> scoringId);

}
