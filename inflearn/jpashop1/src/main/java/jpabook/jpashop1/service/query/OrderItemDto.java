package jpabook.jpashop1.service.query;

import jpabook.jpashop1.domain.OrderItem;

public class OrderItemDto{

    private String itemName;
    private int orderPrice;
    private int count;

    public OrderItemDto(OrderItem orderItem){
        itemName = orderItem.getItem().getName();
        orderPrice = orderItem.getOrderPrice();
        count = orderItem.getCount();
    }
}
