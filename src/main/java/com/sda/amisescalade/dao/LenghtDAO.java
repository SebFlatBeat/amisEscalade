package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.Lenght;
import com.sda.amisescalade.entities.Road;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LenghtDAO extends JpaRepository<Lenght, Long> {
    @Query("select l from Lenght l left join fetch l.road r where r.sector.id = :idsecteur")
    public List <Lenght> findLenghtBySectorId(@Param("idsecteur") Long id);

    @Query("select lenght from Lenght lenght left join fetch lenght.road r where r.sector.id = :idsecteur")
    public Lenght findBySectorId(@Param("idsecteur") Long id);

}


