package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationDAO extends JpaRepository <Reservation, Long> {
public List<Reservation> findReservationsByOwner(String username);
}
