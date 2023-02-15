package springmvc.coffeeStore2.member;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    //생성 > controller의 patch
    public Member createMember(Member member) {

        Member createdMember=member;
        return createdMember;
    }

    //수정 > controller의 update
    public Member updateMember(Member member) {
        Member updatedMember=member;
        return member;
    }

    //1명 조회 > controller의 getOOO
    public Member findMember(long memberId) {

        Member member = new Member(memberId, "haha@gmail.com", "하늘", "010-2222-2222");

        return member;

    }

    //N명 조회 > controller의 getOOOs
    public List<Member> findMembers() {
        List<Member> members=List.of(
                new Member(1,"haha@gmail.com","하늘","010-2222-2222"),
                new Member(2,"tata@gmail.com","타늘","010-3333-3333")
        );


        return members;
    }

    //삭제 > controller의 delete
    public void deleteMember(long memberId) {

    }
}
