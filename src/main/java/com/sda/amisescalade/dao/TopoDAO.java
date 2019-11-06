package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.Topo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TopoDAO extends JpaRepository <Topo,Long>  {

    public List<Topo> findTopoByClimbUserId(Long id);

    public List<Topo> findTopoBySpotId(Long id);

    public List<Topo> findTopoByAvailableTrue();

}
