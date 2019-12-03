package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.CommentSector;
import com.sda.amisescalade.entities.CommentSpot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentSectorDAO extends JpaRepository<CommentSector, Long> {
    public List<CommentSector> findBySectorId(Long sectorId);
}
