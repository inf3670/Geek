import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EtudiantReponse } from '../model/etudiant-reponse';
import { EtudiantRequest } from '../model/etudiant-request';

@Injectable({
  providedIn: 'root'
})
export class EtudiantService {
  private readonly apiUrl: string = "http://localhost:8080/etudiant";
  constructor(private http: HttpClient) { }

  public getAllEtudiant(): Observable<EtudiantReponse[]> {
    return this.http.get<EtudiantReponse[]>(`${this.apiUrl}`);
  }

  public createEtudiant(etudiant: EtudiantRequest): Observable<EtudiantRequest>{
    return this.http.post<EtudiantRequest>(`${this.apiUrl}`, etudiant);
  }
}
