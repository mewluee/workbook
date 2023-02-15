package springmvc.coffeeStore2.member;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")  // (1) spring의 bean으로 등록이 된다.
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);
    MemberResponseDto memberToMemberResponseDto(Member member);
}
