package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorDAO extends JpaRepository <Sector,Long> {
}
