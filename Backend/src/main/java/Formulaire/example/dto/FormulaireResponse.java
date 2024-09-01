package Formulaire.example.dto;

import Formulaire.example.enums.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormulaireResponse {
    private Long id;
    private TypeFormulaire typeFormulaire;
    private String date;
    private Sexe sexe;
    private String nom;
    private String prenom;
    private String email;
    private String numero;
    private String pays;
    private String adresse;
    private NiveauLangue niveauLangueActuel;
    private NiveauLangue niveauLangueInscription;
    private NiveauInformatique niveauInformatique;
    private String dateDebutCoursInfo;
    private String domaineInfoSouhaiter;
    private NiveauEtude niveauEtude;
    private String specialite;
    private String dateHautDiplom;
    private String raisonInscription;
    private String dateDebutCours;
    private String infoRecommandataire;
    private String messageSupplementaire;
}
