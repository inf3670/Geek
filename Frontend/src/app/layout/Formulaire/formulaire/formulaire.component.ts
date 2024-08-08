import { Component } from '@angular/core';
import { ImportsModule } from '../../../import';
import { Sexe } from '../../../enums/sexe';
import { NiveauEtude } from '../../../enums/niveauEtude';
import { RaisonInscription } from '../../../enums/raisonInscription';
import { NiveauLangue } from '../../../enums/NiveauLangue';
import { Pays } from '../../../enums/pays';
import { ErrorMessagesComponent } from '../../../error/error-messages/error-messages.component';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { trimValidator } from '../../../utils/custom-validator';
import { ConfirmationService, MessageService } from 'primeng/api';
import { ValidatorService } from '../../../services/validator.service';
import { ReactiveFormsModule } from '@angular/forms';
import { EtudiantService } from '../../../services/etudiant.service';
import { take } from 'rxjs';

@Component({
  selector: 'app-formulaire',
  standalone: true, 
  imports: [ReactiveFormsModule, ImportsModule, ErrorMessagesComponent],
  templateUrl: './formulaire.component.html',
  styleUrl: './formulaire.component.css'
})
export class FormulaireComponent { 

  constructor(private etudiantService: EtudiantService, private confirmationService: ConfirmationService, private messageService: MessageService, private validatorService: ValidatorService) {
  }

  Sexe = Sexe;
  NiveauLangue = NiveauLangue;
  NiveauEtude = NiveauEtude;
  RaisonInscription = RaisonInscription;
  Pays = Pays;

  loginForm: FormGroup = new FormGroup({
    nom: new FormControl('', [trimValidator, Validators.required]),
    prenom: new FormControl('', [trimValidator, Validators.required]),
    date: new FormControl('', [Validators.required]),
    sexe: new FormControl('', [Validators.required]),
    email: new FormControl('', [trimValidator, Validators.required, Validators.email ]),
    numero: new FormControl('', [trimValidator, Validators.required]),
    pays: new FormControl('', [Validators.required]),
    adresse: new FormControl('', [trimValidator, Validators.required]),
    niveauLangueActuel: new FormControl('', [Validators.required]),
    niveauLangueInscription: new FormControl('', [Validators.required]),
    niveauEtude: new FormControl('', [Validators.required]),
    specialite: new FormControl('', [trimValidator, Validators.required]),
    dateHautDiplom: new FormControl('', [Validators.required]),
    raisonInscription: new FormControl('', [Validators.required]),
    dateDebutCours: new FormControl('', [Validators.required]),
    infoRecommandataire: new FormControl(''),  
    messageSupplementaire: new FormControl(''),
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
    this.etudiantService.createEtudiant({...this.loginForm.value})
    .pipe(take(1)).subscribe({
      next:(): void =>{
        console.log(this.loginForm.value);
        this.loginForm.reset();
      },
      error: (): void=> {
        this.messageService.add({severity: 'error', summary: 'Create Employee error', detail: 'Create Employee error'});
      }
    })
  }
}
