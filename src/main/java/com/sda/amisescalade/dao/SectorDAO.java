package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.Sector;
import com.sda.amisescalade.entities.Spot;
import com.sda.amisescalade.entities.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SectorDAO extends JpaRepository <Sector,Long> {

    public List<Sector> findSectorsBySpotId(Long id);

    public  List<Sector> findBySpot(List<Spot> spot);

    public List<Sector> findBySectorName(Optional<String> sectorName);

    @Query("select distinct sector from Sector sector left join fetch sector.spot")
    public List<Sector> findAllSpotBySectors();

    List<Spot> findById(Optional<Long> sectorId);

    @Query("select distinct  count (sector.spot.id) as NumberOfSector from Sector sector group by sector.spot.id order by NumberOfSector")
    public List<Long> findNumberOfSector();

}
