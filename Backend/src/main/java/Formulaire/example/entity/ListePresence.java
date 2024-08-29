package Formulaire.example.entity;

import Formulaire.example.enums.Sexe;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ListePresence {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private Sexe genre;

    private String nom;

    private String prenom;

    @Column(unique = true)
    private String email;

    private String telephone;

    private String heureArivee;

    private String heureDepart;

    private String motif;
}
