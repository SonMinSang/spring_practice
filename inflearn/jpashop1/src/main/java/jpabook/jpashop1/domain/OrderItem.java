package jpabook.jpashop1.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jpabook.jpashop1.domain.item.Item;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice;
    private int count;

    public void setOrder(Order order){
        this.order = order;
    }

    private OrderItem(Item item, int orderPrice, int count){
        this.item = item;
        this.orderPrice = orderPrice;
        this.count = count;
    }

    //생성메서드
    public static OrderItem createOrderItem(Item item, int orderPrice, int count){
        OrderItem orderItem = new OrderItem(item, orderPrice, count);
        item.removeStock(count);
        return orderItem;
    }

    //비즈니스 로직
    public void cancel(){
        getItem().addStock(count);
    }

    public int getTotalPrice(){
        return getOrderPrice() * getCount();
    }
}
