import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FormulaireResponse } from '../model/formulaire-response';
import { FormulaireRequest } from '../model/formulaire-request';

@Injectable({
  providedIn: 'root'
})
export class FormulaireService {
  private readonly apiUrl: string = "http://localhost:8080/formulaire";
  constructor(private http: HttpClient) { }

  public getAllFormulaire(): Observable<FormulaireResponse[]> {
    return this.http.get<FormulaireResponse[]>(`${this.apiUrl}`);
  }

  public createFormulaire(formulaire: FormulaireRequest): Observable<FormulaireRequest>{
    return this.http.post<FormulaireRequest>(`${this.apiUrl}`, formulaire);
  }
}
