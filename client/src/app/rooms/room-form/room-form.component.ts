import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Room} from '../shared/room';

@Component({
    selector: 'app-room-form',
    templateUrl: './room-form.component.html',
    styleUrls: ['./room-form.component.css']
})
export class RoomFormComponent {

    /** Input parameter for the current room. */
    @Input() room!: Room;

    /** Emits an event if the user has saved the form. */
    @Output() save = new EventEmitter<Room>();
    /** Emits an event if the user has cancelled the form. */
    @Output() cancel = new EventEmitter();

    constructor() {
    }

    onSubmit() {
        this.save.emit(this.room);
    }

    onCancel() {
        this.cancel.emit();
    }
}
