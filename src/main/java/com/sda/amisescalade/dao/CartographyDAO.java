package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.Cartography;
import com.sda.amisescalade.entities.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CartographyDAO extends JpaRepository <Cartography,Long> {

    @Query("select distinct carto from Cartography carto order by carto.codePostalCartography asc ")
    public List<Cartography> findAllCity();

    public Optional<Cartography> findById (Long id);

    @Query("select distinct carto.departmentNameCartography from Cartography carto inner join Spot spot on carto.departmentNameCartography = spot.department")
    public List<String> findDistinctByDepartmentCartography();

    @Query("select distinct carto.communeCartography from Cartography carto inner join Spot spot on carto.communeCartography = spot.city")
    public List<String> findDistinctByCityCartography();

    @Query("select distinct carto.regionCartography from Cartography carto inner join Spot spot on carto.regionCartography = spot.region")
    public List<String> findDistinctByRegionCartography();

    @Query("select distinct carto.countryCartography from Cartography carto inner join Spot spot on carto.countryCartography = spot.country")
    public List<String> findDistinctByCountryCartography();

    List<Spot> findById(Optional<Long> cartographyCityId);
}
