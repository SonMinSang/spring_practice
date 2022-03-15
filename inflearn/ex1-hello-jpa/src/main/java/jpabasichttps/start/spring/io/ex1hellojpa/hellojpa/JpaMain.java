package jpabasichttps.start.spring.io.ex1hellojpa.hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            /* 생성
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");
            em.persist(member);*/

            /* 조회
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());
             */

            /* 수정
            Member editMember = em.find(Member.class, 1L);
            editMember.setName("HelloJPA");
             */
            /* 삭제
            Member deleteMember = em.find(Member.class, 1L);
            em.remove(deleteMember);
             */
            /* 리스트 조회
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();
            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }*/
           /* //비영속
            Member member = new Member();
            //영속
            member.setUsername("A");
            em.persist(member);
*/

            //준영속
            // em.detach(member);

            /*Member findMember1 = em.find(Member.class, 101L);
            Member findMember2 = em.find(Member.class, 101L);

            System.out.println("result = " + (findMember1 == findMember2));*/

            Member member = new Member();
            member.setUsername("member1");
            Team team = new Team();

            team.setName("Team1");
            em.persist(team);
            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();
            Team team1 = em.find(Team.class, team.getId());
            System.out.println("team.getMembers().size() = " + team1.getMembers().size());
            
            for (Member m: team.getMembers()){
                System.out.println("member = " + m.getUsername());
            }

            Member m1 = em.getReference(Member.class,member.getId());
            System.out.println("m1 = " + m1.getClass());

            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(m1));
            Hibernate.initialize(m1); //강제 초기화
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(m1));
//            em.detach(m1);
//            em.clear();
//            em.close();

            System.out.println("m1.getUsername() = " + m1.getUsername());
            Member m2 = em.getReference(Member.class,member.getId());
            System.out.println("m2 = " + m2.getClass());

            tx.commit();
        } catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }
}
