package jpabasichttps.start.spring.io.ex1hellojpa.hellojpa;

import javax.persistence.*;

@Entity
public class MemberProduct {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

}
