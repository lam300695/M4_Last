package com.codegym.model;
import javax.persistence.*;

@Entity
@Table(name = "citys")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cityName;

    private double citySize;
    private String cityPeople;
    private String GDP;
    private String cityDici;

    @ManyToOne
    @JoinColumn(name = "nal_id")
    private Nal nal;

    public City() {
    }

    public City(Long id,String cityName, double citySize, String cityPeople, String GDP, String cityDici) {

        this.id = id;
        this.cityName =cityName;
        this.citySize = citySize;
        this.cityPeople = cityPeople;
        this.GDP = GDP;
        this.cityDici = cityDici;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCitySize() {
        return citySize;
    }

    public void setCitySize(double citySize) {
        this.citySize = citySize;
    }

    public String getCityPeople() {
        return cityPeople;
    }

    public void setCityPeople(String cityPeople) {
        this.cityPeople = cityPeople;
    }

    public String getGDP() {
        return GDP;
    }

    public void setGDP(String GDP) {
        this.GDP = GDP;
    }

    public String getCityDici() {
        return cityDici;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCityDici(String cityDici) {
        this.cityDici = cityDici;
    }

    public Nal getNal() {
        return nal;
    }

    public void setNal(Nal nal) {
        this.nal = nal;
    }
}
