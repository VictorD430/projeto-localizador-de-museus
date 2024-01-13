package com.betrybe.museumfinder.dto;

import com.betrybe.museumfinder.model.Coordinate;

/**
 * Record MuseumCreation.
 * @param name
 * @param description
 * @param address
 * @param collectionType
 * @param subject
 * @param url
 * @param coordinate
 */
public record MuseumCreationDto(
  String name,
  String description,
  String address,
  String collectionType,
  String subject,
  String url,
  Coordinate coordinate
) {}
