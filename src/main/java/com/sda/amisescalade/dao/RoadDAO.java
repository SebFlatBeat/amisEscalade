package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.Road;
import com.sda.amisescalade.entities.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoadDAO extends JpaRepository<Road, Long> {
    public List<Road> findRoadsBySectorId(Long id);

    @Query("select distinct road from Road road left join fetch road.sector s order by s asc ")
    public List<Road> findDistinctBySector();

    List<Spot> findById(Optional<Long> roadId);

    @Query("select distinct  count (road.sector.id) as NumberOfRoad from Road road group by road.sector.id order by NumberOfRoad")
    public List<Long> findNumberOfRoad();

}
