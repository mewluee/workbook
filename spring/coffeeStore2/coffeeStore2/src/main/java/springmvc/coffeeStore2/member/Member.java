package springmvc.coffeeStore2.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Getter/Setter는 lombok 라이브러리에서 제공, 게터/세터 메서드 자동 생성
//코드에는 없지만 내부적으로 메서드가 작성되어 있다.
@Getter
@Setter
@NoArgsConstructor //생성자 생성->파라미터 X
@AllArgsConstructor//생성자 생성->모든 멤버필드 파라미터 O
public class Member {

    private long memberId;
    private String email;
    private String name;
    private String phone;
}
