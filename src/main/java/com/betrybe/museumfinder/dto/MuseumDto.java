package com.betrybe.museumfinder.dto;

import com.betrybe.museumfinder.model.Coordinate;

/**
 * Record Museum.
 * @param id
 * @param name
 * @param description
 * @param address
 * @param collectionType
 * @param subject
 * @param url
 * @param coordinate
 */
public record MuseumDto(
    Long id,
    String name,
    String description,
    String address,
    String collectionType,
    String subject,
    String url,
    Coordinate coordinate
) {}
