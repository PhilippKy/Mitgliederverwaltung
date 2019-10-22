package de.nordakademie.iaa.repetitorium.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;

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
    private Integer birthday;

    @Column(nullable = false, name = "Member_DateJoined")
    private Integer dateJoined;

    @Column(nullable = false, length = 8, name = "Member_DateCancelled")
    private Integer dateCancelled;

    @Column(nullable = false, length = 8, name = "Member_DateExit")
    private Integer dateExit;

    @Column(nullable = false, length = 8, name = "Member_Type")
    private String memberType;

    @Column(nullable = false, name = "Member_Fee")
    private Integer membershipFee;

    @Column(nullable = false, name = "Member_PayedFee")
    private Integer payedFee;

    @Column(nullable = false, name = "Member_BankInfo")
    private Integer bankInfo;

    @Column(name = "Member_familyMember")
    private String familyMember;

    public Member() {}

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

    public Integer getBirthday() {
        return birthday;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public Integer getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Integer dateJoined) {
        this.dateJoined = dateJoined;
    }

    public Integer getDateCancelled() {
        return dateCancelled;
    }

    public void setDateCancelled(Integer dateCancelled) {
        this.dateCancelled = dateCancelled;
    }

    public Integer getDateExit() {
        return dateExit;
    }

    public void setDateExit(Integer dateExit) {
        this.dateExit = dateExit;
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

    public String getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(String familyMember) {
        this.familyMember = familyMember;
    }
}
