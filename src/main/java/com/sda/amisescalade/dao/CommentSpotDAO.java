package com.sda.amisescalade.dao;
import com.sda.amisescalade.entities.CommentSpot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentSpotDAO extends JpaRepository<CommentSpot, Long> {
    public List<CommentSpot> findBySpotId(Long spotId);
}
