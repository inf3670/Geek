import { NiveauEtudeOption } from "../enums/niveauEtude";
import {  NiveauLangueOption } from "../enums/niveauLangue";
import { SexeOption } from "../enums/sexe";

export interface FormulaireRequest {
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