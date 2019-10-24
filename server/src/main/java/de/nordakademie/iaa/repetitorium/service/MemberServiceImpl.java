package de.nordakademie.iaa.repetitorium.service;


import de.nordakademie.iaa.repetitorium.dao.MemberDAO;
import de.nordakademie.iaa.repetitorium.model.Member;
import org.hibernate.exception.ConstraintViolationException;



public class MemberServiceImpl {

    private MemberDAO memberDAO;


    public void createMember(Member member) throws EntityAlreadyPresentException {

        Member member1 = new Member();
        member.setName("Max Mustermann");
        member.setAddress("Musterstraße 1");
        member.setBirthday(2000-01-01);
        member.setDateJoined(31122010);
        member.setDateCancelled(01012011);
        member.setDateExit(02012011);
        member.setMemberType("Vollmitglied");
        member.setMembershipFee(25);
        member.setPayedFee(50);
        member.setBankInfo(123456789);
        member.setFamilyMember("");

        try {
            memberDAO.persistMember(member);
        }
        catch (ConstraintViolationException e) {
            throw new EntityAlreadyPresentException();
        }
    }

}
