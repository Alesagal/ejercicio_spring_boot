package es.apba.oper.practicas.ejercicio_spring_boot.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="COUNTRIES")
public class Country implements Serializable {

    @Id
    @Column(name = "ISO_CODE", length = 2)
    private String isoCode;

    @Column(nullable = false, length = 100)
    private String name;

    @Version
    private Long version;

    public Country() {
    }

    public Country(String isoCode, String name) {
        this.isoCode = isoCode;
        this.name = name;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVersion() {
        return version;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.isoCode != null ? this.isoCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Country other = (Country) obj;
        if ((this.isoCode == null) ? (other.isoCode != null) : !this.isoCode.equals(other.isoCode)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Country{" + "isoCode=" + isoCode + ", name=" + name + '}';
    }

}
