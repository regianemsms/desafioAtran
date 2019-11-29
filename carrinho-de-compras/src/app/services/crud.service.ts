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

  insert(path: string, entity: any): Observable<any> {
    return this.http.post(`${environment.apiUrl}${path}`, entity);
  }

  update(path: string, entity: any): Observable<any> {
    return this.http.put(`${environment.apiUrl}${path}`, entity);
  }

  delete(path: string, id: number): Observable<any> {
    return this.http.delete(`${environment.apiUrl}${path}/${id}`);
  }

  joinRequests(requests: Observable<any>[]): Observable<any[]> {
    return forkJoin(requests);
  }
}
