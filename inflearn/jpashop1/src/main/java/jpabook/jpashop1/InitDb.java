package jpabook.jpashop1;

import jpabook.jpashop1.domain.*;
import jpabook.jpashop1.domain.item.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.dbInit1();
        initService.dbInit2();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;
        public void dbInit1(){
            Member member = new Member("userA", new Address("서울", "1", "1111"));
            em.persist(member);

            Book book1 = new Book("JPA1 BOOK", 10000, 100);
            em.persist(book1);
            Book book2 = new Book("JPA2 BOOK", 20000, 100);
            em.persist(book2);

            OrderItem orderItem1 = OrderItem.createOrderItem(book1, 10000, 1);
            OrderItem orderItem2 = OrderItem.createOrderItem(book2, 20000, 2);

            Delivery delivery = new Delivery(member.getAddress());
            Order order  = Order.createOrder(member, delivery, orderItem2, orderItem1);
            em.persist(order);
        }

        public void dbInit2(){
            Member member = new Member("userB", new Address("전주", "2", "2222"));
            em.persist(member);

            Book book1 = new Book("SPRING1 BOOK", 20000, 200);
            em.persist(book1);
            Book book2 = new Book("SPRING2 BOOK", 40000, 300);
            em.persist(book2);

            OrderItem orderItem1 = OrderItem.createOrderItem(book1, 20000, 3);
            OrderItem orderItem2 = OrderItem.createOrderItem(book2, 40000, 4);

            Delivery delivery = new Delivery(member.getAddress());
            Order order  = Order.createOrder(member, delivery, orderItem1, orderItem2);
            em.persist(order);
        }
    }
}
