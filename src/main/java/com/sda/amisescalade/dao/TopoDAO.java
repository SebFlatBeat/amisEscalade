package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.Topo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopoDAO extends JpaRepository <Topo,Long> {
public List<Topo> findTopoByClimbUserId(Long id);

}
