import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, forkJoin, Subject } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CrudService {

  constructor(private http: HttpClient) { }

  list(path: string): Observable<any> {
    const url = `${environment.apiUrl}${path}`;
    return this.http.get(url);
  }

  save(path: string, entity: any): Observable<any> {
    return this.http.post(`${environment.apiUrl}${path}`, entity);
  }

  delete(path: string, id: string): Observable<any> {
    return this.http.delete(`${environment.apiUrl}${path}/${id}`);
  }

  deleteProd(path: string, id: string, idUsuario: string): Observable<any> {
    return this.http.delete(`${environment.apiUrl}${path}/${id}/${idUsuario}`);
  }

  findById(path: string, id: string): Observable<any> {
    return this.http.get(`${environment.apiUrl}${path}/${id}`);
  }

  joinRequests(requests: Observable<any>[]): Observable<any[]> {
    return forkJoin(requests);
  }
}
