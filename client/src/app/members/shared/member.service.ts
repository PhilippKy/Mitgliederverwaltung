import {Injectable} from '@angular/core';
import {Member} from './member';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

const MEMBERS_ENDPOINT = '/rest/members';

/**
 * Angular service for the member entity.
 *
 * @author Stephan Anft
 */
@Injectable({
    providedIn: 'root'
})
export class MemberService {

    constructor(private http: HttpClient) {
    }

    /**
     * List all members.
     * @returns an observable.
     */
    listAllMembers(): Observable<Member[]> {
        return this.http.get<Member[]>(MEMBERS_ENDPOINT);
    }

    /**
     * Saves the given member.
     * @param memberToBeSaved The member to be saved.
     * @returns an observable.
     */
    saveMember(memberToBeSaved: Member): Observable<any> {
        return this.http.put(MEMBERS_ENDPOINT, memberToBeSaved);
    }

    /**
     * Deletes the given member.
     * @param memberToBeDeleted The member to be deleted.
     * @returns an observable.
     */
    deleteMember(memberToBeDeleted: Member): Observable<any> {
        return this.http.delete(`${MEMBERS_ENDPOINT}/${memberToBeDeleted.id}`);
    }

}
