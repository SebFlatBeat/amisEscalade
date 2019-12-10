package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.Lenght;
import com.sda.amisescalade.entities.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SpotDAO extends JpaRepository <Spot,Long> {
    List<Spot> findBySpotName(Optional<String> spotName);

    List<Spot> findBySectors(Optional<Long> sectorId);

    @Query("select distinct spot from Spot spot left join fetch spot.cartography c order by spot.cartography asc ")
    public List<Spot> findAllSpot();

    @Query("select spot from Spot spot left join fetch spot.cartography c where spot.cartography.id = :idcartography")
    public List<Spot> findByCartographySpot(@Param("idcartography") Optional<Long> Id);

    List<Spot> findById(Optional<Long> spotId);

    List<Spot> findByCartography_CommuneCartography(Optional<String> stringOptional);

    List<Spot> findByCartography_DepartmentNameCartography(Optional<String> stringOptional);

    List<Spot> findByCartography_RegionCartography(Optional<String> stringOptional);

    List<Spot> findByCartography_CountryCartography(Optional<String> stringOptional);

}
