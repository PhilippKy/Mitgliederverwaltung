import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Member} from '../shared/member';

/**
 * The member list component.
 * Sources: Project from Lectures (by Stephan Anft), Angular Documentation
 * @author Denis Karpoukhine
 */
@Component({
    selector: 'app-member-list',
    templateUrl: './member-list.component.html',
    styleUrls: ['./member-list.component.css']
})
export class MemberListComponent {

    /** Input parameter for the member array. */
    @Input() members: Member[] = [];

    /** Event emitter if a member has to be edited. */
    @Output() edit = new EventEmitter<Member>();
    /** Event emitter if a member has to be added. */
    @Output() add = new EventEmitter<void>();
    /** Event emitter if a member has to be deleted. */
    @Output() delete = new EventEmitter<Member>();

    /** The currently selected member. */
    selectedMember?: Member;

    MyArray: Array<Member> = [
        new Member(1, 'Peter', 'Bauer', 1  ),
        new Member(2, 'Max', 'Müller', 2  ),
        new Member(3, 'Georg', 'Peters', 1  ),
        new Member(41, 'Johann', 'Schulz', 3  ),
    ];

    constructor() {
    }

    onSelect(member: Member) {
        this.selectedMember = member;
    }

    onEdit() {
        this.edit.emit(this.selectedMember);
    }

    onAdd() {
        this.add.emit();
    }

    onDelete() {
        this.delete.emit(this.selectedMember);
    }
}
