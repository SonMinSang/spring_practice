package jpabasichttps.start.spring.io.ex1hellojpa.hellojpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class AddressEntity {

    @Id @GeneratedValue
    private Long id;

    private Address address;

    public AddressEntity(String city, String street, String zipcode){
        this.address = new Address(city, street, zipcode);
    }
}
