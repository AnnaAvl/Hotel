package com.entity;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clients")
@AttributeOverride(name = "id", column = @Column(name = "ClientID"))
public class Client extends AbstractEntity{
    @Column(name = "Surname", nullable = false, length = 30)
    private String surname;
    @Column(name = "Name", nullable = false, length = 30)
    private String name;
    @Column(name = "Phone", nullable = false, length = 15)
    private String phone;
    @Temporal(TemporalType.DATE)
    @Column(name = "Birthday", length = 10)
    private Date birthday;
    @Column(name = "Passport", nullable = false, length = 20)
    private String passport;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    private List<Booking> bookings;

    public Client() {

    }

    public Client(String surname, String name, String phone, Date birthday, String passport) {
        this.surname = surname;
        this.name = name;
        this.phone = phone;
        this.birthday = birthday;
        this.passport = passport;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
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
