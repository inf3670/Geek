package Formulaire.example.controller;

import Formulaire.example.dto.EtudiantRequest;
import Formulaire.example.dto.EtudiantResponse;
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
@RequestMapping("/etudiant")
@Tag(name = "Gestion des Etudiants", description = "L'API de gestion des étudiants fournit des opérations de gestion des étudiants, y compris la création, la mise à jour et la suppression des dossiers des étudiants.")

public class FormulaireController {
    private final FormulaireService etudiantService;

    @GetMapping
    @Operation(summary = "Obtenir tous les etudiants", description = "retour tous les étudiants.")
    @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Formulaire.class))})
    public List<FormulaireResponse> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    @PostMapping
    @Operation(summary = "Créer un nouveau étudiant", description = "Crée un nouveau étudiant et renvoie l'étudiant créé.")
    @ApiResponse(responseCode = "200", description = " Etudiant crée avec succès",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Formulaire.class))})
    public FormulaireResponse saveFormulaire(@Valid @RequestBody FormulaireRequest formulaireRequest) {
        return formulaireRequest.saveEtudiant(formulaireRequest);
    }
}
