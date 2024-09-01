package Formulaire.example.dto;

import Formulaire.example.enums.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormulaireRequest {
    @NotNull(message = "typeFormulaire cannot be null")
    private TypeFormulaire typeFormulaire;

    @NotNull(message = "Date cannot be null")
    private String date;

    @NotNull(message = "Sexe cannot be null")
    private Sexe sexe;

    @NotNull(message = "Nom cannot be null")
    private String nom;

    @NotNull(message = "Prenom cannot be null")
    private String prenom;

    @NotNull(message = "Email cannot be null")
    private String email;

    @NotNull(message = "Numero cannot be null")
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
