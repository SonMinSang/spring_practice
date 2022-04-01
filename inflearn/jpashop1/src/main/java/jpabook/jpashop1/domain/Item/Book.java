package jpabook.jpashop1.domain.Item;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("B")
public class Book extends Item{
    private String author;
    private String isbn;

    public Book(String name, int price, int stockQuantity){
        super(name,price,stockQuantity);
    }
}
