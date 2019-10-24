package de.nordakademie.iaa.repetitorium.service;

import de.nordakademie.iaa.repetitorium.dao.MemberDAO;
import de.nordakademie.iaa.repetitorium.model.Member;

import javax.inject.Inject;
import java.util.List;

/**
 * Room service implementation.
 *
 * @author Stephan Anft
 */
public class MemberServiceImpl implements MemberService {

    private MemberDAO memberDAO;

    @Override
    public void createNew(Member member) throws EntityAlreadyPresentException {
        if (memberDAO.findBy(member.getName(), member.getAddress()) != null) {
            // Existing room found in database
            throw new EntityAlreadyPresentException();
        }
        memberDAO.persist(member);
    }

    @Override
    public List<Member> findAll() {
        return memberDAO.findAll();
    }

    @Override
    public Member findBy(Long memberId) {
        return memberDAO.findBy(memberId);
    }

    @Override
    public void update(Long memberId, String name,String address, String memberType, Integer membershipFee,
                       Integer payedFee, Integer bankInfo, Member familyMember) throws EntityNotFoundException {
        Member member = findBy(memberId);
        if (member == null) {
            throw new EntityNotFoundException();
        }
        member.setName(name);
        member.setAddress(address);
        member.setMemberType(memberType);
        member.setMembershipFee(membershipFee);
        member.setPayedFee(payedFee);
        member.setBankInfo(bankInfo);
        member.setFamilyMember(familyMember);
    }

    @Override
    public void delete(Long memberId) throws EntityNotFoundException {
        Member member = findBy(memberId);
        if (member == null) {
            throw new EntityNotFoundException();
        }
        memberDAO.delete(member);
    }

    @Inject
    public void setMemberDAO(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }
}
