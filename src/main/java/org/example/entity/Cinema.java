package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    public String name;
    public String address;
    public List<Hall> halls;

    public Cinema(String name, String address) {
        this.name = name;
        this.address = address;
        this.halls = new ArrayList<>();
    }
}