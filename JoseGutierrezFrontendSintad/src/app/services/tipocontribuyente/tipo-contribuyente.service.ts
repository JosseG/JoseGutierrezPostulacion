import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { API_URL } from 'src/app/utils/global-api-url';

@Injectable({
  providedIn: 'root'
})
export class TipoContribuyenteService {
  private http = inject(HttpClient)

  findAll(){
    return this.http.get<any>(`${API_URL}/api/tipocontribuyente`)
  }

  findById(id:number){
    return this.http.get<any>(`${API_URL}/api/tipocontribuyente/${id}`)
  }

  save(tipoContribuyente:any){
    return this.http.post<any>(`${API_URL}/api/tipocontribuyente`,tipoContribuyente);
  }

  update(tipoContribuyente:any){
    return this.http.put<any>(`${API_URL}/api/tipocontribuyente`,tipoContribuyente);
  }
  activar(id:number){
    return this.http.get<any>(`${API_URL}/api/tipocontribuyente/activar/${id}`)
  }
  desactivar(id:number){
    return this.http.get<any>(`${API_URL}/api/tipocontribuyente/desactivar/${id}`)
  }
}
