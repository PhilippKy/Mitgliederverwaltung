import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Room} from '../shared/room';

/**
 * The room list component.
 *
 * @author Stephan Anft
 */
@Component({
    selector: 'app-room-list',
    templateUrl: './room-list.component.html',
    styleUrls: ['./room-list.component.css']
})
export class RoomListComponent {

    /** Input parameter for the room array. */
    @Input() rooms: Room[] = [];

    /** Event emitter if a room has to be edited. */
    @Output() edit = new EventEmitter<Room>();
    /** Event emitter if a room has to be added. */
    @Output() add = new EventEmitter<void>();
    /** Event emitter if a room has to be deleted. */
    @Output() delete = new EventEmitter<Room>();

    /** The currently selected room. */
    selectedRoom?: Room;

    constructor() {
    }

    onSelect(room: Room) {
        this.selectedRoom = room;
    }

    onEdit() {
        this.edit.emit(this.selectedRoom);
    }

    onAdd() {
        this.add.emit();
    }

    onDelete() {
        this.delete.emit(this.selectedRoom);
    }
}
