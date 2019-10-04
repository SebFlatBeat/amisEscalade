package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.Scoring;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoringDAO extends JpaRepository <Scoring,Long> {
}
