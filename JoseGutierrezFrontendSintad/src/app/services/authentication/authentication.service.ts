import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { API_URL } from 'src/app/utils/global-api-url';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private http = inject(HttpClient)

  login(loginCommand:any){
    return this.http.post<any>(`${API_URL}/api/auth/login`,loginCommand)
  }

  registrar(registrarCommand : any){
    return this.http.post<any>(`${API_URL}/api/auth/registrar`, registrarCommand)
  }
  logout(){
    return this.http.post(`${API_URL}/api/auth/logout`,{})
  }

}
