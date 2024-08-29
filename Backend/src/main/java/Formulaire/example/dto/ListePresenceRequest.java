package Formulaire.example.dto;

import Formulaire.example.enums.Sexe;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListePresenceRequest {

    @NotNull(message = "Date cannot be null")
    private String date;

    @NotNull(message = "Sexe cannot be null")
    private Sexe genre;

    private String nom;

    private String prenom;

    private String email;

    private String telephone;

    private String heureArivee;

    private String heureDepart;

    private String motif;
}
