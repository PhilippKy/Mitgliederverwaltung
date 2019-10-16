export class Room {

    constructor(public id?: number,
                public building?: string,
                public roomNumber?: number,
                public seats?: number,
                public projectorPresent?: boolean) {
    }

    equals(other: Room): boolean {
        if (!other) {
            return false;
        }
        return this.building === other.building && this.roomNumber === other.roomNumber;
    }
}
