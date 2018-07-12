package com.capgemini.swedenairlines.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Airport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String city;

    @OneToMany(mappedBy = "currentAirport")
    private Map<String, Airplane> dockedAirplanes = new HashMap<>();

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void refuel(Airplane airplane){
        this.dockedAirplanes.get(airplane.getName()).setFuelInTonnes(airplane.maxFuel);
    }

    public Map<String, Airplane> getDockedAirplanes() {
        return dockedAirplanes;
    }
}
