package springmvc.coffeeStore2.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//▼▼▼▼▼▼MemberController4 의 작동을 위해 주석처리▼▼▼▼▼▼
//@RestController //RestController -> 1.빈등록 2.엔드포인트로 동작함
//@RequestMapping("/v1/members")
public class MemberController2_dto {
    //클라이언트 요청 데이터를 서버에 생성할 때 사용하는 어노테이션
    //http method 타입을 동일하게 맞춰줘야함.
    //post는 늘 클라이언트에서 서버로 데이터를 보낼때 씀(클라이언트로부터 데이터를 받을때 씀)
    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberPostDto) {
        //여기여기 Valid 어노테이션 적용.
        //등록
        return new ResponseEntity<>(memberPostDto, HttpStatus.CREATED);
        // 메서드의 반환타입 String -> ResponseEntity 로 바꿔줘야함.
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") long memberId,
                                      @RequestBody MemberPatchDto memberPatchDto){
        //수정
        memberPatchDto.setMemberId(memberId);
        memberPatchDto.setName("홍길동");

        return new ResponseEntity<>(memberPatchDto,HttpStatus.OK);
    }

    //클라이언트가 서버에 리소스를 조회할 때 사용하는 어노테이션
    // 메서드의 반환타입 String -> ResponseEntity 로 바꿔줘야함.
    @GetMapping("/{member-id}")
    public ResponseEntity getMember( @PathVariable("member-id")long memberId) {
        //1명 조회
        System.out.println("# memberId: " + memberId);

        // not implementation
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 메서드의 반환타입 String -> ResponseEntity 로 바꿔줘야함.
    @GetMapping
    public ResponseEntity getMembers() {
        //N명 조회
        System.out.println("# get Members");

        // not implementation
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") long memberId){
        //삭제
        System.out.println("# delete Member");

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

