import { Injectable } from '@angular/core';
import {AbstractControl, FormGroup, ValidationErrors} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class ValidatorService {

  constructor() { }

  public getErrorMessage(formControl: AbstractControl | null): string {
    if(!formControl){
      return '';
    }

    const errors: ValidationErrors | null= formControl.errors;
    if(!errors){
      return '';
    }

    if(errors['email']){
      return 'Please enter a valid email';
    }

    if(errors['required']){
      return 'This field is required.';
    }

    if (errors['min']) {
      return `The minimum value is ${errors['min'].min}.`;
    }

    if (errors['max']) {
      return `The maximum value is ${errors['max'].max}.`;
    }

    if (errors['trimValidator']) {
      return 'Please enter a valid value. Leading and trailing spaces are not allowed.';
    }

    if (errors['minAgeDate']) {
      return `You must be at least ${errors['minAgeDate'].requiredAge} years old. Current age: ${errors['minAgeDate'].actualAge}.`;
    }

    return 'Invalid input.';
  }

  public getFormValidationErrors(form: FormGroup): string {
    let errorMessages: string = "";
    Object.keys(form.controls).forEach(key => {
      const control = form.get(key);
      if(control && control.errors){
        const error = this.getErrorMessage(control);
        errorMessages += `👉${key}: ${error}\n`;
      }
    });
    return errorMessages;
  }
}
