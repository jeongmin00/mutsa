package register.register.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import register.register.domain.Member;
import register.register.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByEmail(member.getEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public Member login(String email, String password) {
        return memberRepository.findByEmail(email)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }

    @Transactional
    public void changePassword(String email, String currentPassword, String newPassword) {
        Member member = login(email, currentPassword);
        if (member != null) {
            member.setPassword(newPassword);
            memberRepository.save(member);
        } else {
            throw new IllegalArgumentException("현재 비밀번호가 맞지 않습니다.");
        }
    }
}
