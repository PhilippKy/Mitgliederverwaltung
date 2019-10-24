package de.nordakademie.iaa.repetitorium.controller;

import de.nordakademie.iaa.repetitorium.model.Member;
import de.nordakademie.iaa.repetitorium.service.EntityAlreadyPresentException;
import de.nordakademie.iaa.repetitorium.service.EntityNotFoundException;
import de.nordakademie.iaa.repetitorium.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * REST controller for the member entity.
 *
 * @author Iurii Chernovalov
 */
@RestController
public class MemberController {

    private MemberService memberService;

    /**
     * List all members.
     *
     * @return the list of members.
     */
    @RequestMapping(path = "/members", method = GET)
    public List<Member> listMembers() {
        return memberService.findAll();
    }

    /**
     * Saves the given member (either by creating a new one or updating an existing).
     *
     * @param member The member to save.
     */
    @RequestMapping(path = "/members", method = PUT)
    public ResponseEntity saveMember(@RequestBody Member member) {
        try {
            if (member.getMemberId() == null) {
                memberService.createNew(member);
            }
            else {
                memberService.update(member.getMemberId(), member.getName(),member.getAddress(),member.getMemberType(),
                        member.getMembershipFee(),member.getPayedFee(),member.getBankInfo(),member.getFamilyMember());
            }
            return ResponseEntity.ok().build();
        }
        catch (EntityAlreadyPresentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes the room with given id.
     *
     * @param memberId The id of the member to be deleted.
     */
    @RequestMapping(path = "/members/{id}", method = DELETE)
    public ResponseEntity deleteRoom(@PathVariable Long memberId) {
        try {
            memberService.delete(memberId);
            return ResponseEntity.ok(null);
        }
        catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Inject
    public void setRoomService(MemberService memberService) {
        this.memberService = memberService;
    }
}
