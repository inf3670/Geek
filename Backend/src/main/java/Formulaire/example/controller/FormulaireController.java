package Formulaire.example.controller;
import Formulaire.example.dto.FormulaireRequest;
import Formulaire.example.dto.FormulaireResponse;
import Formulaire.example.entity.Formulaire;
import Formulaire.example.service.FormulaireService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/formulaire")
@Tag(name = "Gestion des formulaires", description = "L'API de gestion des formulaires fournit des opérations de gestion des formulaire, y compris la création, la mise à jour et la suppression des formulaires.")

public class FormulaireController {
    private final FormulaireService formulaireService;

    @GetMapping
    @Operation(summary = "Obtenir tous les formulaires", description = "retour tous les formulaires.")
    @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Formulaire.class))})
    public List<FormulaireResponse> getAllFormulaire() {
        return formulaireService.getAllFormulaire();
    }

    @PostMapping
    @Operation(summary = "Créer un nouveau formulaire", description = "Crée un nouveau formulaire et renvoie le formulaire créé.")
    @ApiResponse(responseCode = "200", description = " Formulaire crée avec succès",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Formulaire.class))})
    public FormulaireResponse saveFormulaire(@Valid @RequestBody FormulaireRequest formulaireRequest) {
        return formulaireService.saveFormulaire(formulaireRequest);
    }
}
