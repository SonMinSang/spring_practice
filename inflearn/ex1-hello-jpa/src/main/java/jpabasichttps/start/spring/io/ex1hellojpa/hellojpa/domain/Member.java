package jpabasichttps.start.spring.io.ex1hellojpa.hellojpa.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;

    @Embedded
    private Address address;


    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
