import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Member} from '../shared/member';
import { MemberListComponent } from '../member-list/member-list.component';
/**
 * The member form component
 * Sources: Project from Lectures (by Stephan Anft), Angular Documentation
 * @author Denis Karpoukhine
 */

@Component({
    selector: 'app-member-form',
    templateUrl: './member-form.component.html',
    styleUrls: ['./member-form.component.css']
})
export class MemberFormComponent {

    /** Input parameter for the current member. */
    @Input() member!: Member;

    /** Emits an event if the user has saved the form. */
    @Output() save = new EventEmitter<Member>();
    /** Emits an event if the user has cancelled the form. */
    @Output() cancel = new EventEmitter();

    constructor() {
    }

    onSubmit() {
        
        this.save.emit(this.member);
    }

    onCancel() {
        this.cancel.emit();
    }
}
