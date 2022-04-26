package jpabook.jpashop1.service;

import jpabook.jpashop1.domain.Address;
import jpabook.jpashop1.domain.item.Book;
import jpabook.jpashop1.domain.item.Item;
import jpabook.jpashop1.domain.Member;
import jpabook.jpashop1.domain.Order;
import jpabook.jpashop1.domain.OrderStatus;
import jpabook.jpashop1.exception.NotEnouthStockException;
import jpabook.jpashop1.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderServiceTest {

    @Autowired EntityManager em;
    @Autowired OrderService orderService;
    @Autowired OrderRepository orderRepository;
    @Test
    public void 상품주문() throws Exception {

        //given

        Member member = new Member("회원1", new Address("서울", "강가", "123-123"));
        em.persist(member);

        Book book = new Book("시골 JPA", 10000, 10);
        em.persist(book);

        int orderCount= 2;

        //when
        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        //then
        Order getOrder = orderRepository.findOne(orderId);

        assertEquals(OrderStatus.ORDER, getOrder.getStatus(), "상품 주문시 상태는 ORDER");
        assertEquals(1, getOrder.getOrderItems().size(), "주문한 상품 종류수가 정확해야 한다");
        assertEquals(10000 * orderCount, getOrder.getTotalPrice(), "주문 가격은 가격 * 수량이다.");
        assertEquals(8, book.getStockQuantity(), "주문 수량만큼 재고가 줄어야 한다.");

    }
    @Test
    public void 상품주문_재고수량초과() throws Exception {

        //given
        Member member = new Member("회원1", new Address("서울", "강가", "123-123"));
        em.persist(member);
        Item item = new Book("시골 JPA", 10000, 10);
        em.persist(item);
        //when

        int orderCount = 11;
        //then
        try {
            orderService.order(member.getId(), item.getId(), orderCount);
        } catch(NotEnouthStockException e){
            return ;
        }

    }

    @Test
    public void 주문취소() throws Exception {

        //given
        Member member = new Member("회원1", new Address("서울", "강가", "123-123"));
        em.persist(member);
        Item item = new Book("시골 JPA", 10000, 10);
        em.persist(item);

        int orderCount = 2;
        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);
        //when

        orderService.cancelOrder(orderId);
        //then
        Order getOrder = orderRepository.findOne(orderId);

        assertEquals(OrderStatus.CANCEL, getOrder.getStatus(), "주문 취소시 상태는 CANCEL 이다.");
        assertEquals(10, item.getStockQuantity(), "주문이 취소된 상품은 그만큼 재고가 증가해야 한다.");
    }

    @Test
    public void 상품주() throws Exception {

        //given

        //when

        //then
    }
}