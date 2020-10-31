package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = true)

public class Smartphone extends Product {
    private String manufacturingCompany;

    public Smartphone() {
    }

    public Smartphone(int id, String name, int price, String manufacturingCompany) {
        super(id, name, price);
        this.manufacturingCompany = manufacturingCompany;
    }

    public String getManufacturingCompany() {
        return manufacturingCompany;
    }

    public void setManufacturingCompany(String manufacturingCompany) {
        this.manufacturingCompany = manufacturingCompany;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return manufacturingCompany.equals(that.manufacturingCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), manufacturingCompany);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "manufacturingCompany='" + manufacturingCompany + '\'' +
                '}';
    }
}
