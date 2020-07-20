package org.example.orderstate;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-08 20:00:55
 */
public class Order {

    private Integer id;

    private OrderStatus status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}
