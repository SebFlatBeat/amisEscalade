package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.Sector;
import com.sda.amisescalade.entities.Topo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectorDAO extends JpaRepository <Sector,Long> {

    public List<Sector> findSectorsBySpotId(Long id);
}
