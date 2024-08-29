import { Component, OnInit, ViewChild } from '@angular/core';
import { ImportsModule } from '../../import';
import { Sexe, SexeOption } from '../../enums/sexe';
import { NiveauEtude, NiveauEtudeOption } from '../../enums/niveauEtude';
import { RaisonInscription, RaisonInscriptionOption } from '../../enums/raisonInscription';
import { Pays, PaysOption } from '../../enums/pays';
import { ErrorMessagesComponent } from '../../error/error-messages/error-messages.component';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { trimValidator } from '../../utils/custom-validator';
import { ConfirmationService, MessageService, SelectItem } from 'primeng/api';
import { ValidatorService } from '../../services/validator.service';
import { ReactiveFormsModule } from '@angular/forms';
import { FormulaireService } from '../../services/formulaire.service';
import { take } from 'rxjs'; 
import { TypeFormulaire, TypeFormulaireOption } from '../../enums/typeFormulaire';
import { TitleFormulairePipe } from '../../pipe/title-formulaire.pipe';
import { NiveauLangue, NiveauLangueOption } from '../../enums/niveauLangue';
import { NiveauInformatique, NiveauInformatiqueOption } from '../../enums/niveauInformatique';
import { Table } from 'primeng/table';
import { ListePresenceService } from '../../services/listePresenceService';
import { ListePresenceRequest } from '../../model/listePresence-request';
import { ListePresenceReponse } from '../../model/listePresence-response';

@Component({ 
  selector: 'app-formulaire',
  standalone: true, 
  imports: [TitleFormulairePipe, ReactiveFormsModule, ImportsModule, ErrorMessagesComponent],
  templateUrl: './formulaire.component.html',
  styleUrl: './formulaire.component.css'
})
export class FormulaireComponent  implements OnInit{ 

  constructor(private listPresenceService: ListePresenceService, private formulaireService: FormulaireService, private confirmationService: ConfirmationService, private messageService: MessageService, private validatorService: ValidatorService) {
  } 

  selectedValue: string = "Cours d'allemand (en ligne/présentiel)";
  choixFormulaire: string = this.selectedValue;
  blockFormulaire: boolean = true;
  tableauPresence: boolean = false;
  tableauPresence1: boolean = false;
  tableauPresence2: boolean = false;
  infoPersoFieldsets: boolean = true;
  niveauLangueFieldsets: boolean = true;
  niveauEtudeFieldsets: boolean = true;
  infoSuplFieldsets: boolean = true;
  competenceInfoFieldsets: boolean = false;

  Sexe: SexeOption[] = [];
  NiveauLangue: NiveauInformatiqueOption[] = [];
  NiveauEtude: NiveauEtudeOption [] = [];
  RaisonInscription: RaisonInscriptionOption[] = [];
  Pays: PaysOption[] = [];
  TypeFormulaire: TypeFormulaireOption[] = [];
  NiveauInformatique: NiveauInformatiqueOption[] = [];

  @ViewChild('myTable', {read: Table}) myTable!: Table;

  listeDePresence!: ListePresenceRequest[];
  clonelisteDePresence: { [s: string]: ListePresenceRequest } = {};

  ngOnInit(): void {
    this.Sexe = Object.keys(Sexe).map(key => Sexe[key]);
    this.NiveauLangue = Object.keys(NiveauLangue).map(key => NiveauLangue[key]);
    this.NiveauEtude = Object.keys(NiveauEtude).map(key => NiveauEtude[key]);
    this.RaisonInscription = Object.keys(RaisonInscription).map(key => RaisonInscription[key]);
    this.Pays = Object.keys(Pays).map(key => Pays[key]);
    this.TypeFormulaire = Object.keys(TypeFormulaire).map(key => TypeFormulaire[key]);
    this.NiveauInformatique = Object.keys(NiveauInformatique).map(key => NiveauInformatique[key]); 
  
    this.gettAllListPresence ();
  }

  loginForm: FormGroup = new FormGroup({
    nom: new FormControl('', [trimValidator, Validators.required]),
    prenom: new FormControl('', [trimValidator, Validators.required]),
    date: new FormControl('', [Validators.required]),
    sexe: new FormControl<SexeOption | null>(null),
    email: new FormControl('', [trimValidator, Validators.required, Validators.email ]),
    numero: new FormControl('', [trimValidator, Validators.required]),
    pays: new FormControl('', [Validators.required]),
    adresse: new FormControl('', [trimValidator, Validators.required]),
    niveauLangueActuel: new FormControl<NiveauLangueOption | null>(null),
    niveauLangueInscription: new FormControl<NiveauLangueOption | null>(null),
    niveauEtude: new FormControl<NiveauEtudeOption | null>(null),
    specialite: new FormControl('', [trimValidator, Validators.required]),
    specialitee: new FormControl('', [trimValidator, Validators.required]),
    dateHautDiplom: new FormControl('', [Validators.required]),
    dateHautDiplome: new FormControl('', [Validators.required]),
    raisonInscription: new FormControl<RaisonInscriptionOption | null>(null),
    dateDebutCours: new FormControl('', [Validators.required]),
    infoRecommandataire: new FormControl(''),  
    messageSupplementaire: new FormControl(''),
    niveauInformatique: new FormControl(trimValidator, [Validators.required]),
    dateDebutCoursInfo: new FormControl(trimValidator, [Validators.required]),
    niveauInformatiquee: new FormControl<NiveauInformatiqueOption | null>(null),
    domaineInfoSouhaiter: new FormControl('', [Validators.required]),
  });

  onSubmit(event: Event): void {
    if(!this.loginForm.valid){
      this.loginForm.markAllAsTouched();
      this.messageService.add(
        {
          severity: 'error',
          summary: 'Error',
          detail: this.validatorService.getFormValidationErrors(this.loginForm)
        });
    }else{
      this.confirmationService.confirm({
        target: event.target as EventTarget,
        message: 'Êtes-vous sûr de vouloir enregistrer cet étudiant ?',
        header: 'Confirmation',
        icon: 'pi pi-exclamation-triangle',
        acceptIcon:"none",
        rejectIcon:"none",
        rejectButtonStyleClass:"p-button-text",
        acceptLabel: "Oui",
        rejectLabel: "Non",
        accept: () => {
          this.saveEtudiant();
          this.messageService.add({ severity: 'info', summary: 'Confirmé', detail: 'étudiant inscrit avec succès' });
        },
        reject: () => {
            this.messageService.add({ severity: 'error', summary: 'Rejeté', detail: 'Vous avez rejeté', life: 3000 });
        }
    });
    }
  } 

  saveEtudiant(): void{
    this.formulaireService.createEtudiant({...this.loginForm.value})
    .pipe(take(1)).subscribe({
      next:(): void =>{
        this.loginForm.reset();
      },
      error: (): void=> {
        this.messageService.add({severity: 'error', summary: 'Create Employee error', detail: 'Create Employee error'});
      }
    })
  }

  onTypeFormulaire(event: any): void {
    this.selectedValue = event.value;
    if(this.selectedValue){
      this.choixFormulaire = this.selectedValue;
      switch(this.selectedValue){
        case "Formulaire de Présence":
          this.blockFormulaire = false;
          this.tableauPresence1 = true;
          break
        case "Cours d'allemand (en ligne/présentiel)":
        case "Cours d'anglais (en ligne/présentiel)":
          this.tableauPresence1 = false;
          this.blockFormulaire = true;
          this.infoPersoFieldsets = true;
          this.competenceInfoFieldsets = false;
          this.niveauLangueFieldsets = true;
          this.niveauEtudeFieldsets = true;
          this.infoSuplFieldsets = true;
          break;
        case "Cours de secrétariat":
        case "Cours d'informatique (en ligne/présentiel)":
        case "Aide à l'obtention d'un visa pour le Canada":
        case "Aide à l'obtention d'un visa pour l'Allemagne":
          this.tableauPresence1 = false;
          this.blockFormulaire = true;
          this.infoPersoFieldsets = true;
          this.competenceInfoFieldsets = false;
          this.niveauLangueFieldsets = false;
          this.niveauEtudeFieldsets = true;
          this.infoSuplFieldsets = true;
          break;
        case "Cours d'informatique":
          this.tableauPresence1 = false;
          this.blockFormulaire = true;
          this.infoPersoFieldsets = true;
          this.competenceInfoFieldsets = true;
          this.niveauLangueFieldsets = false;
          this.niveauEtudeFieldsets = true;
          this.infoSuplFieldsets = true;
          break;
        default:
          this.tableauPresence1 = false;
          this.blockFormulaire = true;
          this.infoPersoFieldsets = true;
          this.competenceInfoFieldsets = false;
          this.niveauLangueFieldsets = true;
          this.niveauEtudeFieldsets = true;
          this.infoSuplFieldsets = true;
      }
    }
  }

  private gettAllListPresence () {
    this.listPresenceService.getAllListPresence().subscribe(res=>{
      this.listeDePresence = res;
      console.log(this.listeDePresence);
    })
    console.log("test");
  }

  public udpdatePresence(presence: ListePresenceReponse){
    this.clonelisteDePresence[presence.id as string] = { ...presence };

  }

  public deleteOnePresence(index: number, id: string):void {
    console.log(id);
    this.listPresenceService.deleteOnePresence(id).subscribe({
      next: () => {
        this.listeDePresence.splice(index, 1);
        this.messageService.add({ severity: 'info', summary: 'Supprimer', detail: 'présence supprimée avec succès' });
        console.log(`présence avec pour ID ${id} supprimée avec succès.`);
      },
      error: (error) => {
        this.messageService.add({ severity: 'error', summary: 'Error', detail: 'Erreur suprimant la présence' });
        console.error('Erreur suprimant la présence', error);
      }
    }); 
  }

  public onRowEditInit(presence: ListePresenceReponse) {
    this.clonelisteDePresence[presence.id as string] = { ...presence };
  }

  public onRowEditSave(presence: ListePresenceReponse) {
    this.listPresenceService.updatePresence(presence.id, presence).subscribe({
      next: () => {
        delete this.clonelisteDePresence[presence.id as string];
        this.messageService.add({ severity: 'success', summary: 'Success', detail: 'Mise à jour réussie' });
      },
      error: (err) => {
        this.messageService.add({ severity: 'error', summary: 'Error', detail: 'Erreur lors de la mise à jour' });
      }
    });
    
    delete this.clonelisteDePresence[presence.id as string];
  }

  public onRowEditCancel(presence: ListePresenceReponse, index: number) {
      this.listeDePresence[index] = this.clonelisteDePresence[presence.id as string];
      delete this.clonelisteDePresence[presence.id as string];
  }

  public addRow() {
    const newPresence: ListePresenceRequest = {
        date: this.getCurrentDate(),
        genre: this.Sexe[0]?.value || '', 
        nom: '',
        prenom: '',
        email: '',
        telephone: '',
        heureArivee: '',
        heureDepart: '',
        motif: ''
    };

    this.listPresenceService.createNewPresence(newPresence).subscribe({
      next: (response: ListePresenceReponse) => {
          this.listeDePresence.unshift(response);
          this.myTable.editingRowKeys[response.id] = true;
          this.clonelisteDePresence[response.id as string] = { ...response };
          this.messageService.add({ severity: 'success', summary: 'Ajout Réussi', detail: 'Nouvelle présence ajoutée' });
      },
      error: (error) => {
          this.messageService.add({ severity: 'error', summary: 'Erreur', detail: 'Impossible d\'ajouter la présence' });
          console.error('Erreur lors de l\'ajout de la présence', error);
      }
     });
  }

  public getCurrentDate(): string {
    const today = new Date();
    const day = String(today.getDate()).padStart(2, '0');
    const month = String(today.getMonth() + 1).padStart(2, '0'); 
    const year = today.getFullYear();

    return `${day}.${month}.${year}`;  
  }
}
