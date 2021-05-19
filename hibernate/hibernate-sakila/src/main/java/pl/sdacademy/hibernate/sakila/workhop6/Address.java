package pl.sdacademy.hibernate.sakila.workhop6;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "address_id")
    private Integer addressId;

    private String address;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public Address() {
    }

    public Address(String address, City city) {
        this.address = address;
        this.city = city;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public String getAddress() {
        return address;
    }

    public City getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", address='" + address + '\'' +
                ", city=" + city +
                '}';
    }
}
