package org.example.entity;

public class Hall {
    public int number;
    public int rows;
    public int seatsPerRow;
    public boolean[][] seats; // true - занято, false - свободно

    public Hall(int number, int rows, int seatsPerRow) {
        this.number = number;
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        this.seats = new boolean[rows][seatsPerRow];
    }
}