package springmvc.coffeeStore2.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


//@RequestMapping 어노테이션의 produce는 응답데이터를 어떤 미디어 타입으로 클라이언트에게 전송할지 설정
//이거 설정안해놓으면 json타입이 아니라 string타입으로 반환함.
//@RequestMapping(value = "/v1/members", produces = {MediaType.APPLICATION_JSON_VALUE})

//▼▼▼▼▼▼MemberController2 의 작동을 위해 주석처리▼▼▼▼▼▼
//@RestController //RestController -> 1.빈등록 2.엔드포인트로 동작함
//@RequestMapping("/v1/members")
public class MemberController_no_dto {
    //클라이언트 요청 데이터를 서버에 생성할 때 사용하는 어노테이션
    //http method 타입을 동일하게 맞춰줘야함.
    //post는 늘 클라이언트에서 서버로 데이터를 보낼때 씀(클라이언트로부터 데이터를 받을때 씀)
    @PostMapping
    public ResponseEntity postMember(@RequestParam("email") String email,
                             @RequestParam("name") String name,
                             @RequestParam("phone") String phone) {
        System.out.println("# email: " + email);
        System.out.println("# name: " + name);
        System.out.println("# phone: " + phone);

        //문자열 json형식으로 수작업했음. 메서드의 반환타입  ResponseEntity -> String 로 바꿔줘야함.
        /*String response =
                "{\"" +
                        "email\":\""+email+"\"," +
                        "\"name\":\""+name+"\",\"" +
                        "phone\":\"" + phone+
                        "\"}";
        return response;*/

        Map<String, String> map=new HashMap<>();
        map.put("email", email);
        map.put("name", name);
        map.put("phone", phone);

        return new ResponseEntity<>(map, HttpStatus.CREATED);
        // 메서드의 반환타입 String -> ResponseEntity 로 바꿔줘야함.
    }

    //클라이언트가 서버에 리소스를 조회할 때 사용하는 어노테이션
    // 메서드의 반환타입 String -> ResponseEntity 로 바꿔줘야함.
    @GetMapping(value="/{member-id}", consumes="application/json")
    public ResponseEntity getMember( @PathVariable("member-id")long memberId) {
        System.out.println("# memberId: " + memberId);

        // not implementation
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 메서드의 반환타입 String -> ResponseEntity 로 바꿔줘야함.
    @GetMapping
    public ResponseEntity getMembers() {
        System.out.println("# get Members");

        // not implementation
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
