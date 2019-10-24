package de.nordakademie.iaa.repetitorium.service;


import de.nordakademie.iaa.repetitorium.dao.MemberDAO;
import de.nordakademie.iaa.repetitorium.model.Member;

import org.hibernate.exception.ConstraintViolationException;




public class TestMemberServiceImpl {

    private MemberDAO memberDAO;


    public void createMember(Member member) throws EntityAlreadyPresentException {


        member.setName("Max Mustermann");
        member.setAddress("Musterstraße 1");
        member.setBirthday(2000, 1, 1);
        member.setDateJoined(1999, 12,31);
        member.setDateCancelled(2001,1,1);
        member.setDateExit(2001,1,2);
        member.setMemberType("Vollmitglied");
        member.setMembershipFee(25);
        member.setPayedFee(50);
        member.setBankInfo(123456789);
        //  member.setFamilyMember(member);

        try {
            memberDAO.persistMember(member);
            memberDAO.findBy(1);

        }
        catch (ConstraintViolationException e) {
            throw new EntityAlreadyPresentException();
        }
    }

}
