package com.entity;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bookings")
@AttributeOverride(name = "id", column = @Column(name = "BookingID"))
public class Booking extends AbstractEntity {
    @Temporal(TemporalType.DATE)
    @Column(name = "CheckInDate", nullable = false)
    private Date checkInDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "CheckOutDate", nullable = false)
    private Date checkOutDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RoomNumber", nullable = false)
    @JsonProperty("roomNumber")
    private Room room;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PromotionID", nullable = false)
    @JsonProperty("promotionID")
    private Promotion promotion;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ClientID", nullable = false)
    @JsonProperty("clientID")
    private Client client;

    public Booking() {
    }

    public Booking(Date checkInDate, Date checkOutDate, Room room, Promotion promotion, Client client) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
        this.promotion = promotion;
        this.client = client;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @JsonGetter("clientID")
    public long getClientID() {
        return client.getId();
    }

    @JsonGetter("promotionID")
    public long getPromotionID() {
        return promotion.getId();
    }

    @JsonGetter("roomNumber")
    public long getRoomID() {
        return room.getId();
    }
}
