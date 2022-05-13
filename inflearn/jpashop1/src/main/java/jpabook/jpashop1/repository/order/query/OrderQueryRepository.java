package jpabook.jpashop1.repository.order.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderQueryRepository {

    private final EntityManager em;

    public List<OrderQueryDto> findOrderQueryDtos(){
        List<OrderQueryDto> result = findOrders();

        result.forEach(o -> {
            List<OrderItemQueryDto> ordersItems = findOrderItems(o.getOrderId());
        });
    }

    private List<OrderItemQueryDto> findOrderItems(Long order){
        return em.createQuery(
                "select new jpabook.jpashop1.repository.order.query.OrderItemQueryDto()" +
                        " from OrderItem oi" +
                        " join oi.item i" +
                        " where oi.order.id = :orderId", OrderItemQueryDto.class)
                .setParameter("orderId", orderId)
                .getResultList();
    }

    public List<OrderQueryDto> findOrders(){
        return em.createQuery(
                "select new jpabook.jpashop1.repository.order.query.OrderQueryDto(o.id, m.name, o.orderDate, o.status, d.address)" +           "from Order o" +
                        " join o.member m" +
                        " join o.delivery d", OrderQueryDto.class)
                .getResultList();
        )
    }
}
