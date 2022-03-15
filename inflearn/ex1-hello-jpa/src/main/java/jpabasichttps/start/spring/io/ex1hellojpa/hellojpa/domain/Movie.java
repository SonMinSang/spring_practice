package jpabasichttps.start.spring.io.ex1hellojpa.hellojpa.domain;

import lombok.Getter;
import javax.persistence.Entity;

@Entity
@Getter
public class Movie extends Item{
    private String director;
    private String actor;
}
