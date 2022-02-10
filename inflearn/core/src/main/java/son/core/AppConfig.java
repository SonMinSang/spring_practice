package son.core;

import son.core.discount.DiscountPolicy;
import son.core.discount.FixDiscountPolicy;
import son.core.discount.RateDiscountPolicy;
import son.core.member.MemberService;
import son.core.member.MemberServiceImpl;
import son.core.member.MemoryMemberRepository;
import son.core.order.OrderService;
import son.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){

        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
