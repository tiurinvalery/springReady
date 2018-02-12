package com.yopselmopsel.service.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "part_order")
public class PartOrder extends BaseEntity {
    @Column(name = "number_in_order")
    private int number;

    @Column(name = "total_price")
    private Long totalPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "good_id")
    private Good good;

    public int getNumber() {
        return number;
    }


    public void setNumber(int number) {

        this.number = number;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartOrder partOrder = (PartOrder) o;
        return number == partOrder.number &&
                Objects.equals(totalPrice, partOrder.totalPrice) &&
                Objects.equals(order, partOrder.order) &&
                Objects.equals(good, partOrder.good);
    }


}
