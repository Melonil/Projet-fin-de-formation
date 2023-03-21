import { Agence } from "./agence";
import { Client } from "./client";

export interface Compte {
    id: number;
    numCompte: string;
    solde: number;
    dateCreation: Date;
    client: Client;
    agence: Agence;
    decouvertAutorise: number;
    
}
