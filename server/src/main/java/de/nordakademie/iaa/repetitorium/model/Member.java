package de.nordakademie.iaa.repetitorium.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity representing a Member.
 *
 * @author Philipp Kopetzky
 */

@Entity
@Table(name = "Member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId;

    @NaturalId
    @Column(nullable = false, name = "Member_Name")
    private String name;

    @Column(nullable = false, name = "Member_Address")
    private String address;

    @Column(nullable = false, name = "Member_Birthday")
    private Date birthday;

    @Column(nullable = false, name = "Member_DateJoined")
    private Date dateJoined;

    @Column(nullable = false, name = "Member_DateCancelled")
    private Date dateCancelled;

    @Column(nullable = false, name = "Member_DateExit")
    private Date dateExit;

    @Column(nullable = false, name = "Member_Type")
    private String memberType;

    @Column(nullable = false, name = "Member_Fee")
    private Integer membershipFee;

    @Column(nullable = false, name = "Member_PayedFee")
    private Integer payedFee;

    @Column(nullable = false, name = "Member_BankInfo")
    private Integer bankInfo;

    @Column(name = "Member_familyMember")
    private Member familyMember;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(int year, int month, int dayOfMonth) {
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(int year, int month, int dayOfMonth) {

    }

    public Date getDateCancelled() {
        return dateCancelled;
    }

    public void setDateCancelled(int year, int month, int dayOfMonth) {

    }

    public Date getDateExit() {
        return dateExit;
    }

    public void setDateExit(int year, int month, int dayOfMonth) {

    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public Integer getMembershipFee() {
        return membershipFee;
    }

    public void setMembershipFee(Integer membershipFee) {
        this.membershipFee = membershipFee;
    }

    public Integer getPayedFee() {
        return payedFee;
    }

    public void setPayedFee(Integer payedFee) {
        this.payedFee = payedFee;
    }

    public Integer getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(Integer bankInfo) {
        this.bankInfo = bankInfo;
    }

    public Member getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(Member memberId) {
        this.familyMember = memberId;
    }
}
