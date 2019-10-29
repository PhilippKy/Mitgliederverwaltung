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

public class ClubMember {


    private Long memberId;
    private String name;
    private String address;
    private Long birthday;
    private Long dateJoined;
    private Long dateCancelled;
    private Long dateExit;
    private String memberType;
    private Integer membershipFee;
    private Integer payedFee;
    private Integer bankInfo;

   // @Column(name = "Member_familyMember")
   // private String familyClubMember;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getMemberId() {
        return memberId;
    }
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @NaturalId
    @Column(nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public Long getBirthday() { return birthday; }
    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public Long getDateJoined() {
        return dateJoined;
    }
    public void setDateJoined(Long dateJoined ) {
        this.dateJoined = dateJoined;
    }

    public Long getDateCancelled() {
        return dateCancelled;
    }
    public void setDateCancelled( Long getDateCancelled) {  this.dateCancelled = dateCancelled;  }

    public Long getDateExit() {
        return dateExit;
    }
    public void setDateExit(Long getDateExit) {  this.dateExit = dateExit;  }

    @Column(nullable = false)
    public String getMemberType() {
        return memberType;
    }
    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    @Column(nullable = false)
    public Integer getMembershipFee() {
        return membershipFee;
    }
    public void setMembershipFee(Integer membershipFee) {
        this.membershipFee = membershipFee;
    }

    @Column(nullable = false)
    public Integer getPayedFee() {
        return payedFee;
    }
    public void setPayedFee(Integer payedFee) {
        this.payedFee = payedFee;
    }

    @Column(nullable = false)
    public Integer getBankInfo() {
        return bankInfo;
    }
    public void setBankInfo(Integer bankInfo) {
        this.bankInfo = bankInfo;
    }

   // public String getFamilyClubMember() {
  //      return familyClubMember;
   // }

   // public void setFamilyClubMember(String clubMemberId) {
    //    this.familyClubMember = clubMemberId;
   // }
}
