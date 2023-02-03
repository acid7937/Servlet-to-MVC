package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach //이놈의 역할은 테스트 하나끝나면 무조건 이걸 한번 실행시켜라 라는 기능임
    void afterEach() {
        memberRepository.clearStore();//테스트 끝나면 깔끔하게 초기화 하려고 한다.
    }

    @Test
    void save() {
        //given //이런걸 주어졌을때
        Member member = new Member("hello",20);
        //when // 이런걸 실행했을때
        Member saveMember = memberRepository.save(member);
        //then //결과가 이거여야해
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> result = memberRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);

    }

}