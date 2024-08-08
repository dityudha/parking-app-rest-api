package com.dityudha.spring.data.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dityudha.spring.data.model.Parking;
public interface ParkingRepository extends JpaRepository<Parking, Long> {
  List<Parking> findByregistnoContaining(String registno);
}