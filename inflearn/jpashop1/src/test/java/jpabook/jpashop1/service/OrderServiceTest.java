package jpabook.jpashop1.service;

import jpabook.jpashop1.domain.Address;
import jpabook.jpashop1.domain.Item.Book;
import jpabook.jpashop1.domain.Item.Item;
import jpabook.jpashop1.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderServiceTest {

    @Autowired
    EntityManager em;
    @Test
    public void 상품주문() throws Exception {

        //given

        Member member = new Member("회원1", new Address("서울", "강가", "123-123"));
        em.persist(member);
        Item book = new Book("시골 JPA", 10000, 10);

        //when


        //then
    }


    @Test
    public void 상품() throws Exception {

        //given

        //when

        //then
    }

    @Test
    public void 상품주() throws Exception {

        //given

        //when

        //then
    }
}