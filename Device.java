package com.example.avirudhtheraja.wirelessremoteapp;

/**
 * Created by avirudhtheraja on 3/6/16.
 */
public class Device {
    private String name;
    private String id;

    public Device(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
