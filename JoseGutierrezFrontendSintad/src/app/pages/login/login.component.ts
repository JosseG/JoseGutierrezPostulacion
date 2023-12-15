import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  formLogin: FormGroup = this.formBuilder.group({
    username: (""),
    password: ("")
  })


  constructor(private formBuilder: FormBuilder, private authService:AuthenticationService, private router: Router){}


  iniciarSesion(){
    console.log("Nombre")

    this.authService.login(this.formLogin.value).subscribe({
      next:(value:any)=>{
        localStorage.setItem("session",value.token)
        this.router.navigate([""])
      },
      error:(error) => {
        console.log(error);
      }

    })
  }
}
