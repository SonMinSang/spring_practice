package son.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import son.hellospring.repository.*;
import son.hellospring.service.MemberService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    //private EntityManager em;
    //private final DataSource dataSource;
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Bean
    public MemberService memberService() {

        return new MemberService(memberRepository);
    }
    //  @Bean
//    public MemberRepository memberRepository() {
// return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        //return new JpaMemberRepository(em);

    //}
}