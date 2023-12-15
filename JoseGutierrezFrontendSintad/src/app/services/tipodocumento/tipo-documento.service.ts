import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { API_URL } from 'src/app/utils/global-api-url';

@Injectable({
  providedIn: 'root'
})
export class TipoDocumentoService {
  private http = inject(HttpClient)

  findAll(){
    return this.http.get<any>(`${API_URL}/api/tipodocumento`)
  }
  findById(id:number){
    return this.http.get<any>(`${API_URL}/api/tipodocumento/${id}`)
  }
  save(tipoDocumento:any){
    return this.http.post<any>(`${API_URL}/api/tipodocumento`,tipoDocumento);
  }
  update(tipoDocumento:any){
    return this.http.put<any>(`${API_URL}/api/tipodocumento`,tipoDocumento);
  }
  activar(id:number){
    return this.http.get<any>(`${API_URL}/api/tipodocumento/activar/${id}`)
  }
  desactivar(id:number){
    return this.http.get<any>(`${API_URL}/api/tipodocumento/desactivar/${id}`)
  }
}
