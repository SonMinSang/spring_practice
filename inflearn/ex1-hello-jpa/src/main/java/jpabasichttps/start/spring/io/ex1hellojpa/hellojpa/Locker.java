package jpabasichttps.start.spring.io.ex1hellojpa.hellojpa;

import javax.persistence.*;

@Entity
public class Locker {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker")
    private Member member;
}
