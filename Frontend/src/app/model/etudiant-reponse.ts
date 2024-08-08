import { NiveauEtude } from "../enums/niveauEtude";
import { NiveauLangue } from "../enums/NiveauLangue";
import { Sexe } from "../enums/sexe";

export interface EtudiantReponse {
    nom:string,
    prenom:string,
    date:string,
    sexe: Sexe
    email:string,
    numero:string,
    pays:string,
    adresse:string,
    niveauLangueAktuel: NiveauLangue,
    niveauLangueInscription: NiveauLangue,
    niveauEtude: NiveauEtude,
    specialite:string,
    dateHautDiplom:string,
    raisonInscription:string,
    dateDebutCours:string,
    infoRecommandataire:string,
    messageSupplementaire:string
}