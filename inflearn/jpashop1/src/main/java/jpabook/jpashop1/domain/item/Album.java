package jpabook.jpashop1.domain.item;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("A")
public class Album extends Item{
   private String artist;
   private String etc;
}
