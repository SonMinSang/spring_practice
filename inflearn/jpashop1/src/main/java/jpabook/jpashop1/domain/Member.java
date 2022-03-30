package jpabook.jpashop1.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    public Member(String name){
        this.name = name;
    }
    @Embedded
    private Address address;

    @OneToMany
    private List<Order> orders = new ArrayList<>();


}
