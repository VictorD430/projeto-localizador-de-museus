package com.betrybe.museumfinder.dto;

import com.betrybe.museumfinder.model.Coordinate;

/**
 * Record Museum.
 *
 * @param id id.
 * @param name name.
 * @param description description.
 * @param address address.
 * @param collectionType collectionType.
 * @param subject subject.
 * @param url url.
 * @param coordinate coordinate.
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
