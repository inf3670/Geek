package Formulaire.example.service;

import Formulaire.example.dto.EtudiantRequest;
import Formulaire.example.dto.EtudiantResponse;
import Formulaire.example.entity.Etudiant;
import Formulaire.example.repository.EtudiantRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EtudiantService {
    private final EtudiantRepository etudiantRepository;
    public List <EtudiantResponse>getAllEtudiants(){
        return etudiantRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public EtudiantResponse saveEtudiant(EtudiantRequest etudiantRequest) {
        return mapToResponse(etudiantRepository.save(mapToEntity(etudiantRequest)));
    }

   // public EtudiantResponse getEmploy

    private Etudiant mapToEntity(EtudiantRequest etudiantRequest) {
        Etudiant etudiant = Etudiant.builder()
                .date(etudiantRequest.getDate())
                .sexe(etudiantRequest.getSexe())
                .nom(etudiantRequest.getNom())
                .prenom(etudiantRequest.getPrenom())
                .email(etudiantRequest.getEmail())
                .numero(etudiantRequest.getNumero())
                .pays(etudiantRequest.getPays())
                .adresse(etudiantRequest.getAdresse())
                .niveauLangueActuel(etudiantRequest.getNiveauLangueActuel())
                .niveauLangueInscription(etudiantRequest.getNiveauLangueInscription())
                .niveauEtude(etudiantRequest.getNiveauEtude())
                .specialite(etudiantRequest.getSpecialite())
                .dateHautDiplom(etudiantRequest.getDateHautDiplom())
                .raisonInscription(etudiantRequest.getRaisonInscription())
                .dateDebutCours(etudiantRequest.getDateDebutCours())
                .infoRecommandataire(etudiantRequest.getInfoRecommandataire())
                .messageSupplementaire(etudiantRequest.getMessageSupplementaire())
                .build();

        return etudiant;
    }

    private EtudiantResponse mapToResponse(Etudiant etudiant) {
        EtudiantResponse etudiantResponse = EtudiantResponse.builder()
                .id(etudiant.getId())
                .date(etudiant.getDate())
                .sexe(etudiant.getSexe())
                .nom(etudiant.getNom())
                .prenom(etudiant.getPrenom())
                .email(etudiant.getEmail())
                .numero(etudiant.getNumero())
                .pays(etudiant.getPays())
                .adresse(etudiant.getAdresse())
                .niveauLangueActuel(etudiant.getNiveauLangueActuel())
                .niveauLangueInscription(etudiant.getNiveauLangueInscription())
                .niveauEtude(etudiant.getNiveauEtude())
                .specialite(etudiant.getSpecialite())
                .dateHautDiplom(etudiant.getDateHautDiplom())
                .raisonInscription(etudiant.getRaisonInscription())
                .dateDebutCours(etudiant.getDateDebutCours())
                .infoRecommandataire(etudiant.getInfoRecommandataire())
                .messageSupplementaire(etudiant.getMessageSupplementaire())
                .build();

        return etudiantResponse;
    }
}