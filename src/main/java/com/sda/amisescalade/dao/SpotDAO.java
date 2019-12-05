package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.Cartography;
import com.sda.amisescalade.entities.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpotDAO extends JpaRepository <Spot,Long> {
    Spot findBySpotName(String spotName);

    Spot findById(Spot spot);

    @Query("select distinct spot from Spot spot left join fetch spot.cartography c order by spot.cartography asc ")
    public List<Spot> findAllSpot();

}
