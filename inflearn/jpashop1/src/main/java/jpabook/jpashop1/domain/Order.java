package jpabook.jpashop1.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public void setMember(Member member){
        this.member = member;
        member.getOrders().add(this);
    }
    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
        delivery.setOrder(this);
    }

    private Order(Member member, Delivery delivery){
        this.member = member;
        this.delivery = delivery;
        this.status = OrderStatus.ORDER;
        this.orderDate = LocalDateTime.now();
    }
    //생성 메서드
    public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems){
        Order order = new Order(member, delivery);
        for (OrderItem orderItem : orderItems){
            order.addOrderItem(orderItem);
        }
        return order;
    }

    //비즈니스 로직
    //주문 취소
    public void cancel(){
        if (delivery.getStatus() == DeliveryStatus.CAMP){
            throw new IllegalStateException("이미 배송된 상품입니다.");
        }
        this.status = OrderStatus.CANCEL;
        for (OrderItem orderItem: orderItems){
            orderItem.cancel();
        }
    }

    //조회 로직
    //전체 주문 가격
    public int getTotalPrice(){
        int totalPrice = 0;
        for (OrderItem orderItem : orderItems){
            totalPrice += orderItem.getTotalPrice();
        }
        return totalPrice;
    }
}
