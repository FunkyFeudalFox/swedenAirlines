package com.capgemini.swedenairlines.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Airplane implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public static final int maxFuel = 5;

    private String name;

    private int fuelInTonnes;

    @ManyToOne
    private Airport currentAirport;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFuelInTonnes() {
        return fuelInTonnes;
    }

    public void setFuelInTonnes(int fuelInTonnes) {
        this.fuelInTonnes = fuelInTonnes;
    }

    public Airport getCurrentAirport() {
        return currentAirport;
    }

    public void setCurrentAirport(Airport currentAirport) {
        this.currentAirport = currentAirport;
    }

    public void flyTo(Airport newAirport){
        if (this.fuelInTonnes > 1){
            fuelInTonnes-=2;
            this.currentAirport.getDockedAirplanes().remove(this.getName());
            this.setCurrentAirport(newAirport);
        }
        else{
            System.out.println("Unable to fly due to low fuel. Please refuel");
        }
    }
}
