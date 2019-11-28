package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.Road;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoadDAO extends JpaRepository<Road, Long> {
    public List<Road> findRoadsBySectorId(Long id);
}
