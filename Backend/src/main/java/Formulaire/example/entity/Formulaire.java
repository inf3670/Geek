package Formulaire.example.entity;

import Formulaire.example.enums.*;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Formulaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeFormulaire typeFormulaire;

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

    private String pays;

    private String adresse;

    @Enumerated(EnumType.STRING)
    private NiveauLangue niveauLangueActuel;

    @Enumerated(EnumType.STRING)
    private NiveauLangue niveauLangueInscription;

    @Enumerated(EnumType.STRING)
    private NiveauInformatique niveauInformatique;

    private String dateDebutCoursInfo;

    private String domaineInfoSouhaiter;

    @Enumerated(EnumType.STRING)
    private NiveauEtude niveauEtude;

    private String specialite;

    private String dateHautDiplom;

    private String raisonInscription;

    private String dateDebutCours;

    private String infoRecommandataire;

    private String messageSupplementaire;
}
