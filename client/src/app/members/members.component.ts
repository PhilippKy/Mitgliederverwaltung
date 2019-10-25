import {Component, OnInit} from '@angular/core';
import {Member} from './shared/member';
import {MemberService} from './shared/member.service';

/**
 * Central member component.
 *
 * @author Stephan Anft
 */
@Component({
    selector: 'app-members',
    templateUrl: './members.component.html',
    styleUrls: ['./members.component.css']
})
export class MembersComponent implements OnInit {

    /** Current member array. */
    members: Member[] = [];

    /** The currently selected member. */
    currentMember?: Member;

    constructor(private memberService: MemberService) {
    }

    ngOnInit() {
        this.reloadList();
    }

    onEditMember(member: Member) {
        this.currentMember = member;
    }

    onAddMember() {
        this.currentMember = new Member();
    }

    onDeleteMember(memberToBeDeleted: Member) {
        this.memberService.deleteMember(memberToBeDeleted).subscribe(() => this.reloadList());
    }

    onSave(memberToBeSaved: Member) {
        this.memberService.saveMember(memberToBeSaved).subscribe(() => this.reloadList());
    }

    onCancel() {
        this.reloadList();
    }

    private reloadList() {
        this.currentMember = undefined;
        this.memberService.listAllMembers().subscribe(members => this.members = members);
    }
}
