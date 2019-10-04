package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotDAO extends JpaRepository <Spot,Long> {
}
