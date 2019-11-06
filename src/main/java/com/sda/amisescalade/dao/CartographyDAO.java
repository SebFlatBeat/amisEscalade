package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.Cartography;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartographyDAO extends JpaRepository <Cartography,Long> {
}
