package jpabook.jpashop1.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@AllArgsConstructor
public class Address { // 값 타입은 변경 불가

    private String city;
    private String street;
    private String zipcode;

    protected Address(){
    }
}
