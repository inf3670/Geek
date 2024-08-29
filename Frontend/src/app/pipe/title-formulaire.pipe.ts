import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'titleFormulaire',
  standalone: true
})
export class TitleFormulairePipe implements PipeTransform {

  transform(typeFormulaire: string): string {
    return "Formulaire d'inscription pour " + typeFormulaire;
  }

}
