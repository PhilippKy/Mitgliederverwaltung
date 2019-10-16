import {Injectable} from '@angular/core';
import {Room} from './room';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

const ROOMS_ENDPOINT = '/rest/rooms';

/**
 * Angular service for the room entity.
 *
 * @author Stephan Anft
 */
@Injectable({
    providedIn: 'root'
})
export class RoomService {

    constructor(private http: HttpClient) {
    }

    /**
     * List all rooms.
     * @returns an observable.
     */
    listAllRooms(): Observable<Room[]> {
        return this.http.get<Room[]>(ROOMS_ENDPOINT);
    }

    /**
     * Saves the given room.
     * @param roomToBeSaved The room to be saved.
     * @returns an observable.
     */
    saveRoom(roomToBeSaved: Room): Observable<any> {
        return this.http.put(ROOMS_ENDPOINT, roomToBeSaved);
    }

    /**
     * Deletes the given room.
     * @param roomToBeDeleted The room to be deleted.
     * @returns an observable.
     */
    deleteRoom(roomToBeDeleted: Room): Observable<any> {
        return this.http.delete(`${ROOMS_ENDPOINT}/${roomToBeDeleted.id}`);
    }

}
