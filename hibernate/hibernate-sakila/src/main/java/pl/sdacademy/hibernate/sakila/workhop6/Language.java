package pl.sdacademy.hibernate.sakila.workhop6;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "language")
public class Language {

    @Id
    @Column (name = "language_id")
    private Integer languageId;

    private String name;

    public Language(Integer languageId, String name) {
        this.languageId = languageId;
        this.name = name;
    }

    public Language() {
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Language{" +
                "languageId=" + languageId +
                ", name='" + name + '\'' +
                '}';
    }
}
