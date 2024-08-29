import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { ListePresenceReponse } from "../model/listePresence-response";
import { Observable } from "rxjs";
import { ListePresenceRequest } from "../model/listePresence-request";

@Injectable({
    providedIn: 'root'
})

export class ListePresenceService {
    private readonly apiUrl: string = "http://localhost:8080/listePresence";
    constructor(private http: HttpClient) { }

    public getAllListPresence(): Observable<ListePresenceReponse[]> {
        return this.http.get<ListePresenceReponse[]>(`${this.apiUrl}`);
    }

    public createNewPresence(listePresenceRequest: ListePresenceRequest): Observable<ListePresenceReponse>{
        return this.http.post<ListePresenceReponse>(`${this.apiUrl}`, listePresenceRequest);
    }

    public updatePresence(id: string, listePresenceRequest: ListePresenceRequest): Observable<ListePresenceReponse>{
        return this.http.put<ListePresenceReponse>(`${this.apiUrl}/${id}`, listePresenceRequest);
      }  

    public deleteOnePresence(id: string): Observable<void>{
        const url = `${this.apiUrl}/${id}`;
        return this.http.delete<void>(url);
    }
};