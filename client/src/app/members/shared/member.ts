export class Member {

    constructor(public id?: number,
                public firstname?: string,
                public lastname?: string,
                /*public address?: string,
                public birthday?: Date,
                public membershipBegin?: Date,
                public membershipEnd?: Date,
                public membershipTermination?: Date,*/
                public membershipType?: number/*,
                public currentFee?: number,
                //pro Jahr eine Spalte Bezahlt/Betrag FEHLT
                public bankAccount?: string,
                public primaryFamilyMember?: Member*/) {
    }
    /*
    • Mitgliedsnummer
    • Name
    • Adresse
    • Geburtstag
    • Datum Eintritt
    • Datum Kündigung
    • Datum Austritt
    • Mitgliedsart
    • aktueller Jahresbeitrag
    • pro Jahr eine Spalte Bezahlt/Betrag
    • Kontoverbindung
    • Verweis zum zuerst eingetretenen Familienmitglied (wenn vorhanden)
    */

    equals(other: Member): boolean {
        if (!other) {
            return false;
        }
        return this.lastname === other.lastname 
            && this.firstname === other.firstname
            && this.id === other.id;
    }
}
