package edu.nf.entity;

import java.util.Objects;

public class City {
    private Integer id;
    private String cityName;
    private String cityCode;
    private String province;

    @Override
    public boolean equals(Object o) {
        if (this == o){ return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        City city = (City) o;
        return Objects.equals(id, city.id) &&
                Objects.equals(cityName, city.cityName) &&
                Objects.equals(cityCode, city.cityCode) &&
                Objects.equals(province, city.province);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityName, cityCode, province);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
