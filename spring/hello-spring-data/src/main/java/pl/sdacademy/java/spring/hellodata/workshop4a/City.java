package pl.sdacademy.java.spring.hellodata.workshop4a;

import javax.persistence.*;

@Entity
@Table(name = "city")
@SequenceGenerator(name = "CitySeq", sequenceName = "city_seq")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CitySeq")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "country_code")
    private Country country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    //warto zachować ostrożność z toString() w klasach encyjnych
    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country + //uwaga na ewentualne leniwe ładowanie!
                '}';
    }
}
