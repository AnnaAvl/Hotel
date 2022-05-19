package com.entity;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rooms")
@AttributeOverride(name = "id", column = @Column(name = "RoomID"))
public class Room extends AbstractEntity{
    @Column(name = "BedsAmount", nullable = false)
    private Integer bedsAmount;
    @Column(name = "DailyCost", nullable = false)
    private double dailyCost;
    @Column(name = "Cleaning", nullable = false)
    private boolean cleaning;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
    private List<Booking> bookings;

    public Room(){
    }

    public Room(Integer bedsAmount, double dailyCost, boolean cleaning, List<Booking> bookings) {
        this.bedsAmount = bedsAmount;
        this.dailyCost = dailyCost;
        this.cleaning = cleaning;
        this.bookings = bookings;
    }

    public Integer getBedsAmount() {
        return bedsAmount;
    }

    public void setBedsAmount(Integer bedsAmount) {
        this.bedsAmount = bedsAmount;
    }

    public double getDailyCost() {
        return dailyCost;
    }

    public void setDailyCost(double dailyCost) {
        this.dailyCost = dailyCost;
    }

    public boolean isCleaning() {
        return cleaning;
    }

    public void setCleaning(boolean cleaning) {
        this.cleaning = cleaning;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @JsonGetter("bookings")
    public int getBookingsSize(){
        return bookings.size();
    }
}
