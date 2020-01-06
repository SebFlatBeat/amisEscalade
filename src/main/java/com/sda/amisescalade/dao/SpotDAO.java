package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.Lenght;
import com.sda.amisescalade.entities.Spot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SpotDAO extends JpaRepository <Spot,Long> {

    @Query("select distinct spot from Spot spot left join fetch spot.cartography c order by spot.cartography.id asc ")
    List<Spot> findAllSpot(Pageable pageable);

    List<Spot> findById(Optional<Long> spotId);

    @Query("select spot from Spot spot where spot.id =:spotId and spot in :listSpot")
    List<Spot> findBySpotIdInList(@Param("spotId") Long id, @Param("listSpot") List<Spot> listSpot);

    @Query("select scoring.road.sector.spot from Scoring scoring where scoring.rating =:scoringString and scoring.road.sector.spot in :listSpot")
    List<Spot> findByScoringInList(@Param("scoringString") String string, @Param("listSpot") List<Spot> listSpot);

    @Query("select spot from Spot spot where spot.cartography.communeCartography =:cartographyCityName and spot in :listSpot")
    List<Spot> findByCartographyCityInList(@Param("cartographyCityName") String string, @Param("listSpot")List<Spot> listSpot);

    @Query("select spot from Spot spot where spot.cartography.departmentNameCartography =:cartographyDepartementName and spot in :listSpot")
    List<Spot> findByCartographyDepartmentInList(@Param("cartographyDepartementName") String string, @Param("listSpot")List<Spot> listSpot);

    @Query("select spot from Spot spot where spot.cartography.regionCartography =:cartographyRegionName and spot in :listSpot")
    List<Spot> findByCartographyRegionInList(@Param("cartographyRegionName") String string, @Param("listSpot")List<Spot> listSpot);

    @Query("select spot from Spot spot where spot.cartography.countryCartography =:cartographyCountryName and spot in :listSpot")
    List<Spot> findByCartographyCountryInList(@Param("cartographyCountryName") String string, @Param("listSpot")List<Spot> listSpot);

    @Query("select road.sector.spot.id, count (road.sector.id) as NumberOfRoad from Road road where  road.sector.spot in :listSpot group by road.sector.spot.id ")
    List<Long[]> findByNumberOfRoadInList(@Param("listSpot") List<Spot> listSpot);

    @Query("select sector.spot.id, count (sector.id) as NumberOfSector from Sector sector where  sector.spot in :listSpot group by sector.spot.id ")
    List<Long[]> findByNumberOfSectorInList(@Param("listSpot") List<Spot> listSpot);
}


