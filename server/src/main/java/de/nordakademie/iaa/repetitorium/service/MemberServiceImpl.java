package de.nordakademie.iaa.repetitorium.service;

import de.nordakademie.iaa.repetitorium.dao.MemberDAO;
import de.nordakademie.iaa.repetitorium.model.ClubMember;

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
    public void createNew(ClubMember clubMember) throws EntityAlreadyPresentException {
        if (memberDAO.findBy(clubMember.getName(), clubMember.getAddress()) != null) {
            // Existing room found in database
            throw new EntityAlreadyPresentException();
        }
        memberDAO.persist(clubMember);
    }

    @Override
    public List<ClubMember> findAll() {
        return memberDAO.findAll();
    }

    @Override
    public ClubMember findBy(Long memberId) {
        return memberDAO.findBy(memberId);
    }

    @Override
    public void update(Long memberId, String name,String address, String memberType, Integer membershipFee,
                       Integer payedFee, Integer bankInfo
            //, ClubMember familyClubMember
                       ) throws EntityNotFoundException {

        ClubMember clubMember = findBy(memberId);
        if (clubMember == null) {
            throw new EntityNotFoundException();
        }
        clubMember.setName(name);
        clubMember.setAddress(address);
        clubMember.setMemberType(memberType);
        clubMember.setMembershipFee(membershipFee);
        clubMember.setPayedFee(payedFee);
        clubMember.setBankInfo(bankInfo);
  //      clubMember.setFamilyClubMember("familyClubMember");
    }

    @Override
    public void delete(Long memberId) throws EntityNotFoundException {
        ClubMember clubMember = findBy(memberId);
        if (clubMember == null) {
            throw new EntityNotFoundException();
        }
        memberDAO.delete(clubMember);
    }

    @Inject
    public void setMemberDAO(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }
}
