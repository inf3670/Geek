package Formulaire.example.utils;

import Formulaire.example.dto.FormulaireRequest;
import Formulaire.example.dto.FormulaireResponse;
import Formulaire.example.dto.ListePresenceRequest;
import Formulaire.example.dto.ListePresenceResponse;
import Formulaire.example.enums.*;
import Formulaire.example.service.FormulaireService;
import Formulaire.example.service.ListePresenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer implements CommandLineRunner {
   public final FormulaireService formulaireService;
   public final ListePresenceService listePresenceService;

    @Override
    public void run(String... args) throws Exception {
        createFormulaire();
        createListePresence();
    }

    private void createFormulaire() {
        FormulaireResponse lucas = formulaireService.saveFormulaire(FormulaireRequest.builder()
                .typeFormulaire(TypeFormulaire.coursAnglais)
                .date("10.02.2024")
                .sexe(Sexe.Masculin)
                .nom("Kengne")
                .prenom("Lucas")
                .email("lucas@gmail.com")
                .numero("+23343454545")
                .pays("Kamerun")
                .adresse("Lan 2, rue 1")
                .niveauLangueActuel(NiveauLangue.A1)
                .niveauLangueInscription(NiveauLangue.A2)
                .niveauInformatique(NiveauInformatique.Intermediaire)
                .dateDebutCoursInfo("23.02.2024")
                .domaineInfoSouhaiter("Softwareentwicklung")
                .niveauEtude(NiveauEtude.BTS)
                .specialite("Informatik")
                .dateHautDiplom("12.02.2000")
                .raisonInscription("Pour aller étudier en Allemagne")
                .dateDebutCours("20.03.2022")
                .infoRecommandataire("Zidane")
                .messageSupplementaire("non")
                .build());

        FormulaireResponse Lilian = formulaireService.saveFormulaire(FormulaireRequest.builder()
                .typeFormulaire(TypeFormulaire.coursAnglais)
                .date("18.03.2020")
                .sexe(Sexe.Féminin)
                .nom("donfack")
                .prenom("Lilian")
                .email("lilian@gmail.com")
                .numero("+67687787")
                .pays("Kamerun")
                .adresse("biemassi 2, rue 6")
                .niveauLangueActuel(NiveauLangue.B1)
                .niveauLangueInscription(NiveauLangue.B2)
                .niveauInformatique(NiveauInformatique.Debutant)
                .dateDebutCoursInfo("23.02.2024")
                .domaineInfoSouhaiter("Softwareentwicklung")
                .niveauEtude(NiveauEtude.BEPC)
                .specialite("Medecine")
                .dateHautDiplom("23.02.2003")
                .raisonInscription("Pour aller étudier en Allemagne")
                .dateDebutCours("20.03.2022")
                .infoRecommandataire("John")
                .messageSupplementaire("je suis contente de pouvoir etudier ici")
                .build());

        FormulaireResponse milen = formulaireService.saveFormulaire(FormulaireRequest.builder()
                .typeFormulaire(TypeFormulaire.assistanceVisaAllemagne)
                .date("30.08.2023")
                .sexe(Sexe.Féminin)
                .nom("Tonfack")
                .prenom("Milen")
                .email("milen@gmail.com")
                .numero("+56656939934")
                .pays("Kamerun")
                .adresse("karrieri 6, rue 6")
                .niveauLangueActuel(NiveauLangue.A1)
                .niveauLangueInscription(NiveauLangue.B1)
                .niveauInformatique(NiveauInformatique.Debutant)
                .dateDebutCoursInfo("23.02.2024")
                .domaineInfoSouhaiter("Softwareentwicklung")
                .niveauEtude(NiveauEtude.Baccalauréat)
                .specialite("Pflege")
                .dateHautDiplom("23.12.2006")
                .raisonInscription("Pour aller travailler en Allemagne")
                .dateDebutCours("20.08.2022")
                .infoRecommandataire("John")
                .build());
    }

    private void createListePresence() {
        ListePresenceResponse lucas = listePresenceService.savePresence(ListePresenceRequest.builder()
                .date("10.02.2024")
                .genre(Sexe.Masculin)
                .nom("Kengne")
                .prenom("Lucas")
                .email("lucas@gmail.com")
                .telephone("+23343454545")
                .heureArivee("08:30")
                .heureDepart("17:00")
                .motif("Réunion")
                .build());

        ListePresenceResponse jule = listePresenceService.savePresence(ListePresenceRequest.builder()
                .date("20.22.2024")
                .genre(Sexe.Masculin)
                .nom("Dongmo")
                .prenom("jule")
                .email("jule@gmail.com")
                .telephone("+235643454545")
                .heureArivee("09:90")
                .heureDepart("12:00")
                .motif("Formation")
                .build());

        ListePresenceResponse Line = listePresenceService.savePresence(ListePresenceRequest.builder()
                .date("10.02.2024")
                .genre(Sexe.Féminin)
                .nom("Titse")
                .prenom("Line")
                .email("Line@gmail.com")
                .telephone("+233435676745")
                .heureArivee("22:30")
                .heureDepart("19:00")
                .motif("Visite client")
                .build());

    }
}
