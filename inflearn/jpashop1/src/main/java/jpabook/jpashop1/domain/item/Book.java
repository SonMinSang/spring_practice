package jpabook.jpashop1.domain.item;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("B")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book extends Item{
    private String author;
    private String isbn;

    public Book(String name, int price, int stockQuantity){
        super(name,price,stockQuantity);
    }
    public Book(String name, int price, int stockQuantity, String author, String isbn){
        super(name,price,stockQuantity);
        this.author = author;
        this.isbn = isbn;
    }
}
