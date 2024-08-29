package Formulaire.example.controller;

import Formulaire.example.dto.ListePresenceRequest;
import Formulaire.example.dto.ListePresenceResponse;
import Formulaire.example.entity.ListePresence;
import Formulaire.example.service.ListePresenceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/listePresence")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Gestion de la liste de presence", description = "L'API pour la gestion de la liste de présence du formulaire.")

public class ListePresenceController {
    private final ListePresenceService listePresenceService;

    @GetMapping
    @Operation(summary = "Obtenir toute la liste de presence", description = "retourne toute la liste de presence.")
    @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ListePresence.class))})
    public List<ListePresenceResponse> getAllListePresence() {
        return listePresenceService.getAllListePresence();
    }

    @PostMapping
    @Operation(summary = "Crée une nouvelle Presence", description = "Crée une nouvelle Présence et la retourne.")
    @ApiResponse(responseCode = "200", description = "Une nouvelle présence crée avec succès",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ListePresence.class))})
    public ListePresenceResponse createNewPresence(@Valid @RequestBody ListePresenceRequest listePresenceRequest) {
        return listePresenceService.savePresence(listePresenceRequest);
    }

    @PutMapping("/{id}")
    @Operation(summary = "modifie la présence", description = "Met à jour la presence existant identifié par l'ID et renvoie l'objet mis à jour.")
    @ApiResponse(responseCode = "200", description = "La présence a été mise à jour avec succès.",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ListePresence.class))})
    @ApiResponse(responseCode = "404", description = "cette Présence n'existe pas")
    public ListePresenceResponse updateListePresence(@PathVariable("id") @Parameter(description = "ID de la présence à mettre à jour") UUID id, @Valid @RequestBody ListePresenceRequest listePresenceRequest) {
        return listePresenceService.updateListePresence(id, listePresenceRequest);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Suprimer la présence", description ="Supprime la présence identifiée par l'ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "présence supprimée avec succès"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public void deleteEmployee(@PathVariable("id") @Parameter(description = "ID de la présence à supprimer") UUID id) {
        listePresenceService.deletePresence(id);
    }
}
