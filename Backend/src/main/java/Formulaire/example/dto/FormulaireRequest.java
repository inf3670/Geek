package Formulaire.example.dto;

import Formulaire.example.enums.NiveauEtude;
import Formulaire.example.enums.NiveauLangue;
import Formulaire.example.enums.Sexe;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormulaireRequest {
    @NotNull(message = "Nom cannot be null")
    private String nom;

    @NotNull(message = "Prenom cannot be null")
    private String prenom;

    @NotNull(message = "Date cannot be null")
    private String date;

    @NotNull(message = "Sexe cannot be null")
    private Sexe sexe;

    @NotNull(message = "Email cannot be null")
    private String email;

    @NotNull(message = "Numero cannot be null")
    private String numero;

    @NotNull(message = "Pays cannot be null")
    private String pays;

    @NotNull(message = "Adresse cannot be null")
    private String adresse;

    @NotNull(message = "NiveauLangueAktuel cannot be null")
    private NiveauLangue niveauLangueActuel;

    @NotNull(message = "NiveauLangueInscription cannot be null")
    private NiveauLangue niveauLangueInscription;

    @NotNull(message = "NiveauEtude be null")
    private NiveauEtude niveauEtude;

    @NotNull(message = "Specialite cannot be null")
    private String specialite;

    @NotNull(message = "DateHautDiplom cannot be null")
    private String dateHautDiplom;

    @NotNull(message = "RaisonInscription cannot be null")
    private String raisonInscription;

    @NotNull(message = "DateDebutCours be null")
    private String dateDebutCours;

    private String infoRecommandataire;

    private String messageSupplementaire;
}
