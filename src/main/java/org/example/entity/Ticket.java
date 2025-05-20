package org.example.entity;

public class Ticket {
    public Session session;
    public int row;
    public int seat;
    public User user;

    public Ticket(Session session, int row, int seat, User user) {
        this.session = session;
        this.row = row;
        this.seat = seat;
        this.user = user;
    }
}