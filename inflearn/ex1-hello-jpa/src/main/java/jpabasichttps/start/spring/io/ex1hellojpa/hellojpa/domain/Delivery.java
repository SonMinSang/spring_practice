package jpabasichttps.start.spring.io.ex1hellojpa.hellojpa.domain;

import javax.persistence.*;

@Entity
public class Delivery extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DELIVERY_ID")
    private Long id;

    @Embedded
    private Address address;
    private DeliveryStatus deliveryStatus;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;
}
