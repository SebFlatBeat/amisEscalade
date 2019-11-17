package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.Cartography;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CartographyDAO extends JpaRepository <Cartography,Long> {

    @Query("select distinct carto.countryCartography from Cartography carto")
    public List<String> findAllCountry();

    @Query("select distinct carto.regionCartography from Cartography carto")
    public List<String> findAllRegion();

    @Query("select distinct carto.departmentCartography, carto.departmentNameCartography from Cartography carto order by carto.departmentCartography asc ")
    public List<String> findAllDepartment();

    @Query("select distinct carto from Cartography carto order by carto.codePostalCartography asc ")
    public List<Cartography> findAllCity();

    public Optional<Cartography> findById (Long id);

}
