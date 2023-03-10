package springmvc.coffeeStore2.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberResponseDto {
    private long memberId;

    private String email;

    private String name;

    private String phone;
}
