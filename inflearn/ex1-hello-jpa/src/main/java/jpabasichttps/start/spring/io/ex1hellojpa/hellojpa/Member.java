package jpabasichttps.start.spring.io.ex1hellojpa.hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
public class Member extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();

    @Embedded
    private Period workPeriod;
    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
            @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "ADDRESS", joinColumns =
            @JoinColumn(name = "MEMBER_ID"))
    private List<Address> addressHistory = new ArrayList<>();

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city",
                column=@Column(name = "WORK_CITY")),
            @AttributeOverride(name="street",
                    column=@Column(name ="WORK_STREET")),
            @AttributeOverride(name="zipcode",
                    column=@Column(name ="WORK_ZIPCODE")),
    })
    private Address workAddress;

    public void changeTeam(Team team){
        this.team = team;

        team.getMembers().add(this);
    }

}
