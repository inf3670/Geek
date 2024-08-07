package Formulaire.example.entity;

import Formulaire.example.enums.NiveauEtude;
import Formulaire.example.enums.NiveauLangue;
import Formulaire.example.enums.Sexe;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private Sexe sexe;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String pays;

    @Column(nullable = false)
    private String adresse;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NiveauLangue niveauLangueActuel;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NiveauLangue niveauLangueInscription;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NiveauEtude niveauEtude;

    @Column(nullable = false)
    private String specialite;

    @Column(nullable = false)
    private String dateHautDiplom;

    @Column(nullable = false)
    private String raisonInscription;

    @Column(nullable = false)
    private String dateDebutCours;

    private String infoRecommandataire;

    private String messageSupplementaire;
}
