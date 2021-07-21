package pl.sdacademy.java.spring.hellodata.workshop4;

import javax.persistence.*;

@Entity
@Table(name = "city")
@SequenceGenerator(name = "CitySeq", sequenceName = "city_seq")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CitySeq")
    private Long id;

    private String name;

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

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
