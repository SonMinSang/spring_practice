package son.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import son.core.discount.DiscountPolicy;
import son.core.discount.FixDiscountPolicy;
import son.core.discount.RateDiscountPolicy;
import son.core.member.MemberService;
import son.core.member.MemberServiceImpl;
import son.core.member.MemoryMemberRepository;
import son.core.order.OrderService;
import son.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()
    
    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
