package com.yopselmopsel.service.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "my_order")
public class Order  extends BaseEntity{

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    Set<PartOrder> orders = new HashSet<PartOrder>();

    @Override
    public String toString() {
        return "Order{" +
                "client=" + client +
                ", orders=" + orders +
                ", price=" + price +
                '}';
    }



    @Column(name = "price", nullable = false)
    private Long price;
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
    public Set<PartOrder> getOrders() {
        return orders;
    }

    public void setOrders(Set<PartOrder> orders) {
        this.orders = orders;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(client, order.client) &&
                Objects.equals(orders, order.orders) &&
                Objects.equals(price, order.price);
    }


}




