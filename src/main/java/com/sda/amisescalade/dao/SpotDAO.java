package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpotDAO extends JpaRepository <Spot,Long> {
    Spot findBySpotName(String spot);

    @Override
    List<Spot> findAll();

    Spot findById(Spot spot);

}
