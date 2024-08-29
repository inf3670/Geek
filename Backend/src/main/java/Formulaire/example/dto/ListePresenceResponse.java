package Formulaire.example.dto;

import Formulaire.example.enums.Sexe;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListePresenceResponse {
    private UUID id;
    private String date;
    private Sexe genre;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String heureArivee;
    private String heureDepart;
    private String motif;
}
