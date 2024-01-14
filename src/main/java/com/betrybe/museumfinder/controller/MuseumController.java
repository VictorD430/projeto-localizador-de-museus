package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Museum controller.
 */
@RestController
@RequestMapping("/museums")
public class MuseumController {
  private MuseumServiceInterface service;

  @Autowired
  public MuseumController(MuseumServiceInterface service) {
    this.service = service;
  }

  /**
   * Museum response.
   *
   * @param newMuseum newMuseum.
   * @return response.
   */
  @PostMapping
  public ResponseEntity<MuseumDto> createMuseum(@RequestBody MuseumCreationDto newMuseum) {
    Museum createdMuseum = service.createMuseum(ModelDtoConverter.dtoToModel(newMuseum));
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(ModelDtoConverter.modelToDto(createdMuseum));
  }

  /**
   * getClosestMuseum.
   *
   * @param lat latitude.
   * @param lng longitude.
   * @param maxDistKm maxDistance.
   * @return return.
   */
  @GetMapping("/closest")
  public ResponseEntity<MuseumDto> getClosestMuseum(
      @RequestParam double lat,
      @RequestParam double lng,
      @RequestParam(name = "max_dist_km") double maxDistKm
  ) {
    Coordinate coordinate = new Coordinate(lat, lng);
    Museum closestMuseum = service.getClosestMuseum(coordinate, maxDistKm);
    return ResponseEntity
        .ok(ModelDtoConverter.modelToDto(closestMuseum));
  }

  /**
   * Get id.
   *
   * @param id id.
   * @return return.
   */
  @GetMapping("/{id")
  public ResponseEntity<MuseumDto> getMuseum(@PathVariable long id) {
    Museum museum = service.getMuseum(id);
    return ResponseEntity.ok(ModelDtoConverter.modelToDto(museum));
  }
}
