import { NiveauEtude, NiveauEtudeOption } from "../enums/niveauEtude";
import { NiveauLangue, NiveauLangueOption } from "../enums/niveauLangue";
import { Sexe, SexeOption } from "../enums/sexe";

export interface FormulaireResponse {
    nom:string,
    prenom:string,
    date:string,
    sexe: SexeOption[],
    email:string,
    numero:string,
    pays:string,
    adresse:string,
    niveauLangueAktuel: NiveauLangueOption[],
    niveauLangueInscription: NiveauLangueOption[],
    niveauEtude: NiveauEtudeOption[],
    specialite:string,
    dateHautDiplom:string,
    raisonInscription:string,
    dateDebutCours:string,
    infoRecommandataire:string,
    messageSupplementaire:string,
}