package com.lhleonardo.antipatterns.detector.microservices.models;

import java.util.List;
import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Microservice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String identifier;

    @Column
    private String name;

    @Column
    private String alias;

    @ElementCollection
    @CollectionTable(name = "microservice_metadata", joinColumns = @JoinColumn(name = "microservice_id"))
    @MapKeyColumn(name = "meta_key")
    @Column(name = "meta_value")
    private Map<String, String> metadata;

    @ElementCollection
    @CollectionTable(name = "microservice_addresses", joinColumns = @JoinColumn(name = "microservice_id"))
    @Column(name = "address")
    private List<String> addresses;
}
