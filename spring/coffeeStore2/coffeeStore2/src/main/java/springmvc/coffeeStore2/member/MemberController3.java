package springmvc.coffeeStore2.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.HashMap;
import java.util.Map;

//내가 이거 3을 뭐할려고 만들었더라..???????????????????????아 컨트롤러...블로그할때 ㅇㅋ.
//@Controller
//@RequestMapping("/v1/members")
public class MemberController3 {
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
    public ResponseEntity getMember( @PathVariable("member-id") long memberId) {
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
