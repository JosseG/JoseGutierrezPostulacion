import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { API_URL } from 'src/app/utils/global-api-url';

@Injectable({
  providedIn: 'root'
})
export class EntidadService {
  private http = inject(HttpClient)

  findAll(){
    return this.http.get<any>(`${API_URL}/api/entidad`);
  }

  findById(id:number){
    return this.http.get<any>(`${API_URL}/api/entidad/${id}`);
  }

  save(entidad:any){
    return this.http.post<any>(`${API_URL}/api/entidad`,entidad);
  }
  update(entidad:any){
    return this.http.put<any>(`${API_URL}/api/entidad`,entidad);
  }

  activar(id:number){
    return this.http.get<any>(`${API_URL}/api/entidad/activar/${id}`)
  }
  desactivar(id:number){
    return this.http.get<any>(`${API_URL}/api/entidad/desactivar/${id}`)
  }
}
