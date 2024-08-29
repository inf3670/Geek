package Formulaire.example.dto;

import Formulaire.example.enums.NiveauEtude;
import Formulaire.example.enums.NiveauLangue;
import Formulaire.example.enums.Sexe;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormulaireResponse {
    private Long id;
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
    private NiveauEtude niveauEtude;
    private String specialite;
    private String dateHautDiplom;
    private String raisonInscription;
    private String dateDebutCours;
    private String infoRecommandataire;
    private String messageSupplementaire;
}
