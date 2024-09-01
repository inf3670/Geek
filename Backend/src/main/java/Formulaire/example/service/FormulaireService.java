package Formulaire.example.service;

import Formulaire.example.dto.FormulaireRequest;
import Formulaire.example.dto.FormulaireResponse;
import Formulaire.example.entity.Formulaire;
import Formulaire.example.repository.FormulaireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FormulaireService {
    private final FormulaireRepository formulaireRepository;
    public List <FormulaireResponse>getAllFormulaire(){
        return formulaireRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public FormulaireResponse saveFormulaire(FormulaireRequest formulaireRequest) {
        return mapToResponse(formulaireRepository.save(mapToEntity(formulaireRequest)));
    }

    private Formulaire mapToEntity(FormulaireRequest formulaireRequest) {
        Formulaire formulaire = Formulaire.builder()
                .typeFormulaire(formulaireRequest.getTypeFormulaire())
                .date(formulaireRequest.getDate())
                .sexe(formulaireRequest.getSexe())
                .nom(formulaireRequest.getNom())
                .prenom(formulaireRequest.getPrenom())
                .email(formulaireRequest.getEmail())
                .numero(formulaireRequest.getNumero())
                .pays(formulaireRequest.getPays())
                .adresse(formulaireRequest.getAdresse())
                .niveauLangueActuel(formulaireRequest.getNiveauLangueActuel())
                .niveauLangueInscription(formulaireRequest.getNiveauLangueInscription())
                .niveauInformatique(formulaireRequest.getNiveauInformatique())
                .dateDebutCoursInfo(formulaireRequest.getDateDebutCoursInfo())
                .domaineInfoSouhaiter(formulaireRequest.getDomaineInfoSouhaiter())
                .niveauEtude(formulaireRequest.getNiveauEtude())
                .specialite(formulaireRequest.getSpecialite())
                .dateHautDiplom(formulaireRequest.getDateHautDiplom())
                .raisonInscription(formulaireRequest.getRaisonInscription())
                .dateDebutCours(formulaireRequest.getDateDebutCours())
                .infoRecommandataire(formulaireRequest.getInfoRecommandataire())
                .messageSupplementaire(formulaireRequest.getMessageSupplementaire())
                .build();

        return formulaire;
    }

    private FormulaireResponse mapToResponse(Formulaire formulaire) {
        FormulaireResponse formulaireResponse =FormulaireResponse.builder()
                .id(formulaire.getId())
                .typeFormulaire(formulaire.getTypeFormulaire())
                .date(formulaire.getDate())
                .sexe(formulaire.getSexe())
                .nom(formulaire.getNom())
                .prenom(formulaire.getPrenom())
                .email(formulaire.getEmail())
                .numero(formulaire.getNumero())
                .pays(formulaire.getPays())
                .adresse(formulaire.getAdresse())
                .niveauLangueActuel(formulaire.getNiveauLangueActuel())
                .niveauLangueInscription(formulaire.getNiveauLangueInscription())
                .niveauInformatique(formulaire.getNiveauInformatique())
                .dateDebutCoursInfo(formulaire.getDateDebutCoursInfo())
                .domaineInfoSouhaiter(formulaire.getDomaineInfoSouhaiter())
                .niveauEtude(formulaire.getNiveauEtude())
                .specialite(formulaire.getSpecialite())
                .dateHautDiplom(formulaire.getDateHautDiplom())
                .raisonInscription(formulaire.getRaisonInscription())
                .dateDebutCours(formulaire.getDateDebutCours())
                .infoRecommandataire(formulaire.getInfoRecommandataire())
                .messageSupplementaire(formulaire.getMessageSupplementaire())
                .build();

        return formulaireResponse;
    }
}