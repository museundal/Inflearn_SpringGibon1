package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //private MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Override
    public void join(Member member) {

        memberRepository.Save(member);

    }

    @Override
    public Member findMember(Long memberId) {

        return memberRepository.findById(memberId);
    }

    //테스트용
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
