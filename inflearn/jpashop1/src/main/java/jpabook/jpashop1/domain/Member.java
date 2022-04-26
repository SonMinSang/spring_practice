package jpabook.jpashop1.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotEmpty
    private String name;

    public Member(String name){
        this.name = name;
    }
    public Member(String name, Address address){
        this.name = name;
        this.address = address;
    }
    @Embedded
    private Address address;

    @OneToMany
    private List<Order> orders = new ArrayList<>();


}
