package com.yopselmopsel.service.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "good")
public class Good extends BaseEntity {

    @Column(name = "name", length = 45, nullable = false, unique = true)
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {

        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Column(name = "number")
    private int number;
    public void setNumber(int number) {
        this.number = number;
    }
    public int getNumber(){
        return this.number;
    }


    @Column(name = "price")
    private Long price;


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "good")
    Set<PartOrder> orderSet = new HashSet<PartOrder>();

    public Set<PartOrder> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<PartOrder> orderSet) {
        this.orderSet = orderSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return number == good.number &&
                Objects.equals(name, good.name) &&
                Objects.equals(price, good.price) &&
                Objects.equals(orderSet, good.orderSet);
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", orderSet=" + orderSet +
                '}';
    }
}
