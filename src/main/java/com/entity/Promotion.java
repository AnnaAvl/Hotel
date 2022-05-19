package com.entity;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "promotions")
@AttributeOverride(name = "id", column = @Column(name = "PromotionID"))
public class Promotion extends AbstractEntity{
    @Column(name = "PromotionName", nullable = false, length = 50)
    private String name;
    @Column(name = "Discount", nullable = false)
    private Integer discount;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "promotion")
    private List<Booking> bookings;

    public Promotion(){
    }

    public Promotion(String name, Integer discount, List<Booking> bookings) {
        this.name = name;
        this.discount = discount;
        this.bookings = bookings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
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
