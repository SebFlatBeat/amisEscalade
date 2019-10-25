package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpotDAO extends JpaRepository <Spot,Long> {
    Spot findBySpotName(Spot spot);

    @Override
    List<Spot> findAll();
}
