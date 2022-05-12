package jpabook.jpashop1.repository.query;

import jpabook.jpashop1.domain.Address;
import jpabook.jpashop1.domain.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderQueryDto {

    private Long orderId;
    private String name;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private Address address;
    private List<OrderItemQueryDto> orderItems;
}
