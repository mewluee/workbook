package springmvc.ex1.coffeeStore.member;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

//RestController -> 1.빈등록 2.엔드포인트로 동작함
@RestController
@RequestMapping(value = "/v1/members", produces = {MediaType.APPLICATION_JSON_VALUE})
public class MemberController {

    //클라이언트 요청 데이터를 서버에 생성할 때 사용하는 어노테이션
    //http method 타입을 동일하게 맞춰줘야함.
    @PostMapping
    public String postMember(@RequestParam("email") String email,
                             @RequestParam("name") String name,
                             @RequestParam("phone") String phone) {
        System.out.println("# email: " + email);
        System.out.println("# name: " + name);
        System.out.println("# phone: " + phone);

        String response =
                "{\"" +
                        "email\":\""+email+"\"," +
                        "\"name\":\""+name+"\",\"" +
                        "phone\":\"" + phone+
                        "\"}";
        return response;
    }

    //클라이언트가 서버에 리소스를 조회할 때 사용하는 어노테이션
    @GetMapping("/{member-id}")
    public String getMember(@PathVariable("member-id")long memberId) {
        System.out.println("# memberId: " + memberId);

        // not implementation
        return null;
    }

    @GetMapping
    public String getMembers() {
        System.out.println("# get Members");

        // not implementation
        return null;
    }
}
