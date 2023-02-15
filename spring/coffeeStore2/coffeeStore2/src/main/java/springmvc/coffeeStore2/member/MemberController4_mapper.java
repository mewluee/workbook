package springmvc.coffeeStore2.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


//▼▼▼▼▼▼MemberController5 의 작동을 위해 주석처리▼▼▼▼▼▼
//@RestController //RestController -> 1.빈등록 2.엔드포인트로 동작함
//@RequestMapping("/v1/members")
public class MemberController4_mapper {

    //개선 전 문제점
    //1. controller 핸들러 메서드의 책임과 역할에 관한 문제
    //   요청 데이터를 Service클래스로 전달하고, 응답 데이터를 클라이언트로 다시 전송하는 단순한 역할이어야함.
    //   그런데 여기서는 핸들러가 응답 데이터를 만드는 작업(DTO->Entity객체로 변환작업)까지 함.
    //2. Service계층에서 사용하는 Entity객체를 다루고 있는 문제. (엔티티객체를 응답데이터로 전송까지함)
    //   결과적으로 계층 간의 역할 분리가 제대로 이루어지지 않음.

    private final MemberService memberService;
    private final MemberMapper1 memberMapper;

    public MemberController4_mapper(MemberService memberService, MemberMapper1 mEmberMapper) {
        this.memberService = memberService;
        this.memberMapper = mEmberMapper;
    }

    //등록
    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberPostDto) {


        /*//수정 전 (entity만드는 작업을 직접했었음)
        Member member=new Member();
        member.setEmail(memberPostDto.getEmail());
        member.setName(memberPostDto.getName());
        member.setPhone(memberPostDto.getPhone());

        Member response = memberService.createMember(member);

        return new ResponseEntity<>(response, HttpStatus.CREATED);*/

        //수정 후
        Member member=memberMapper.memberPostDtoToMember(memberPostDto); // Dto객체 -> (순수)객체
        Member response=memberService.createMember(member); // 위에서만든 객체로 비즈니스 로직을 지나서 응답 데이터 생성(순수 객체)

        // Entity 매개변수로 ResponseDto객체가 필요함.
        // 즉 mapper을 통해서 (순수)객체 -> Dto객체로 만듬.
        return new ResponseEntity<>(memberMapper.memberToMemberResponseDto(response),HttpStatus.CREATED);

    }

    //수정
    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") long memberId,
                                      @RequestBody MemberPatchDto memberPatchDto){
        System.out.println("# patch");
        /*//수정 전
        Member member = new Member();
        memberPatchDto.setMemberId(memberPatchDto.getMemberId());
        memberPatchDto.setName(memberPatchDto.getName());
        memberPatchDto.setPhone(memberPatchDto.getPhone());


        Member response = memberService.updateMember(member);
        return new ResponseEntity<>(response,HttpStatus.OK);*/

        //수정 후

        memberPatchDto.setMemberId(memberId); //이작업은 도통 왜하는지 모르겠네..
        Member member=memberMapper.memberPatchDtoToMember(memberPatchDto); //patchDto객체->순수객체로
        Member response=memberService.updateMember(member); //비즈니스 로직을 통해 응답 데이터(순수객체) 생성

        //순수객체 -> responseDto객체
        return new ResponseEntity<>(memberMapper.memberToMemberResponseDto(response),HttpStatus.OK);
    }

    //1명 조회
    @GetMapping("/{member-id}")
    public ResponseEntity getMember( @PathVariable("member-id")long memberId) {

        System.out.println("# memberId: " + memberId);

        /*//수정전
        Member response = memberService.findMember(memberId);
        return new ResponseEntity<>(response,HttpStatus.OK);*/

        //수정후
        //위랑 다르게 클라이언트에서 데이터를 주는게 아니라 조회를 요청하는 거라서 ..
        Member response=memberService.findMember(memberId);
        return new ResponseEntity<>(memberMapper.memberToMemberResponseDto(response),HttpStatus.OK);
    }

    //N명 조회
    @GetMapping
    public ResponseEntity getMembers() {

        System.out.println("# get Members");

        /*//수정 전
        List<Member> response = memberService.findMembers();
        return new ResponseEntity<>(response,HttpStatus.OK);*/

        //수정 후
        List<Member> members=memberService.findMembers();
        List<MemberResponseDto> response=members.stream()
                .map(member -> memberMapper.memberToMemberResponseDto(member))
                .collect(Collectors.toList());

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    //삭제
    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") long memberId){
        System.out.println("# delete Member");

        /*//수정 전
        memberService.deleteMember(memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);*/

        //수정 후
        memberService.deleteMember(memberId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
        //delete할땐 <> 필요없음.
    }

    //로직 짤때 중요하게 봐야하는 것
    //Dto객체를 순수객체로 만들 필요가 있는 경우 > Post, Patch
    // (단, 조회기능은 그냥 바로 id를 매개변수로 넣어 서비스 객체를 통해서 비즈니스 로직을 지나 새로운 응답데이터(순수객체) 생성)
    //순수객체로 만들고 서비스 객체를 통해서 비즈니스 로직을 지나 새로운 응답데이터(순수객체) 생성
    //클라이언트에 보내줄때는 순수객체->ResponseDto로 만들어서 보내줘야함. (그런데 delete는 그럴 필요없음)

    //아.....이거 이렇게 안하고....MapStruct이란 라이브러리가 Mapper자동 생성해줌..ㅎㅎ...흑ㅠ

}

