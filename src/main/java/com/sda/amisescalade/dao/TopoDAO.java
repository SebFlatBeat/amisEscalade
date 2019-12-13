package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.Spot;
import com.sda.amisescalade.entities.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopoDAO extends JpaRepository <Topo,Long>  {

    public List<Topo> findTopoByClimbUserId(Long id) ;

    public List <Topo> findBySpotId(Long id);

    public List<Topo>findByCartographyId(Long id);

    public List<Topo> findTopoByAvailableTrue();

    @Query("select topo from Topo topo where topo.spot.id =:spotId and topo in :listTopo")
    List<Topo> findBySpotIdInList(@Param("spotId") Long id, @Param("listTopo") List<Topo> listTopo);

    @Query("select topo from Topo topo where topo.cartography.communeCartography =:cartographyCityName and topo in :listTopo")
    List<Topo> findByCartographyCityInList(@Param("cartographyCityName") String string, @Param("listTopo")List<Topo> listTopo);

    @Query("select topo from Topo topo where topo.cartography.departmentNameCartography =:cartographyDepartementName and topo in :listTopo")
    List<Topo> findByCartographyDepartmentInList(@Param("cartographyDepartementName") String string, @Param("listTopo")List<Topo> listTopo);

    @Query("select topo from Topo topo where topo.cartography.regionCartography =:cartographyRegionName and topo in :listTopo")
    List<Topo> findByCartographyRegionInList(@Param("cartographyRegionName") String string, @Param("listTopo")List<Topo> listTopo);

    @Query("select topo from Topo topo where topo.cartography.countryCartography =:cartographyCountryName and topo in :listTopo")
    List<Topo> findByCartographyCountryInList(@Param("cartographyCountryName") String string, @Param("listTopo")List<Topo> listTopo);



}
