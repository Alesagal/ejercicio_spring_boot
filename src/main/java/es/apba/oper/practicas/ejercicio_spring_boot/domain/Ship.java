package es.apba.oper.practicas.ejercicio_spring_boot.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "SHIPS")
public class Ship implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "SHIP_ID")
    private Long shipId;

    @Column(name = "IMO_CODE", nullable = false, unique = true)
    private Integer imoCode;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "GROSS_TONS", nullable = false)
    private Integer grossTons;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "DATE_BUILT")
    private Date dateBuilt;

    @ManyToOne(optional = false)
    private Country flag;

    @ManyToOne(optional = false)
    private ShipType type;

    @Version
    private Long version;

    public Ship() {
    }

    public Ship(Integer imoCode, String name, Integer grossTons, Date dateBuilt, Country flag, ShipType type) {
        this.imoCode = imoCode;
        this.name = name;
        this.grossTons = grossTons;
        this.dateBuilt = dateBuilt;
        this.flag = flag;
        this.type = type;
    }

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public Integer getImoCode() {
        return imoCode;
    }

    public void setImoCode(Integer imoCode) {
        this.imoCode = imoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrossTons() {
        return grossTons;
    }

    public void setGrossTons(Integer grossTons) {
        this.grossTons = grossTons;
    }

    public Date getDateBuilt() {
        return dateBuilt;
    }

    public void setDateBuilt(Date dateBuilt) {
        this.dateBuilt = dateBuilt;
    }

    public Country getFlag() {
        return flag;
    }

    public void setFlag(Country flag) {
        this.flag = flag;
    }

    public ShipType getType() {
        return type;
    }

    public void setType(ShipType type) {
        this.type = type;
    }

    public Long getVersion() {
        return version;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.imoCode != null ? this.imoCode.hashCode() : 0);
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
        final Ship other = (Ship) obj;
        if (this.imoCode != other.imoCode && (this.imoCode == null || !this.imoCode.equals(other.imoCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ship{" + "imoCode=" + imoCode + ", name=" + name + '}';
    }


}
