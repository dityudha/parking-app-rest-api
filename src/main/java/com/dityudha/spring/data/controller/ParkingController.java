package com.dityudha.spring.data.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dityudha.spring.data.model.Parking;
import com.dityudha.spring.data.repository.ParkingRepository;


//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/parking")
public class ParkingController {
	  @Autowired
	  ParkingRepository parkingRepository;
	  @GetMapping("/cars")
	  public ResponseEntity<List<Parking>> getAllParkings(@RequestParam(required = false) String registno) {
	    try {
	      List<Parking> cars = new ArrayList<Parking>();
	      if (registno == null)
	        parkingRepository.findAll().forEach(cars::add);
	      else
	        parkingRepository.findByregistnoContaining(registno).forEach(cars::add);
	      if (cars.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(cars, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  @GetMapping("/cars/{id}")
	  public ResponseEntity<Parking> getCarsById(@PathVariable("id") long id) {
	    Optional<Parking> parkingData = parkingRepository.findById(id);
	    if (parkingData.isPresent()) {
	      return new ResponseEntity<>(parkingData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  @PostMapping("/cars")
	  public ResponseEntity<Parking> createParkings(@RequestBody Parking parking) {
	    try {
	      Parking _parking = parkingRepository
//	          .save(new Parking());
		  .save(new Parking(parking.getRegistno(), parking.getArrival(), parking.getDeprature(), parking.getStatus(), parking.getBill(), false));
	      return new ResponseEntity<>(_parking, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  @PutMapping("/cars/{id}")
	  public ResponseEntity<Parking> updateParkings(@PathVariable("id") long id, @RequestBody Parking parking) {
	    Optional<Parking> parkingData = parkingRepository.findById(id);
	    if (parkingData.isPresent()) {
	      Parking _parking = parkingData.get();
		  _parking.setRegistno(parking.getRegistno());
	      _parking.setArrival(parking.getArrival());
		  _parking.setDeprature(parking.getDeprature());
		  _parking.setStatus(parking.getStatus());
		  _parking.setBill(parking.getBill());
	      return new ResponseEntity<>(parkingRepository.save(_parking), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  @DeleteMapping("/cars/{id}")
	  public ResponseEntity<HttpStatus> deleteParking(@PathVariable("id") long id) {
	    try {
	      parkingRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  @DeleteMapping("/cars")
	  public ResponseEntity<HttpStatus> deleteAllParkings() {
	    try {
	      parkingRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}