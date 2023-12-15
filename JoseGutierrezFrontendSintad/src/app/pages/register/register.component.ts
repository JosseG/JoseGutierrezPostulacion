import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication/authentication.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  formRegister: FormGroup = this.formBuilder.group({
    username: (""),
    password: (""),
    idRol:("")
  })


  constructor(private formBuilder: FormBuilder, private authService:AuthenticationService, private router: Router){}


  registrar(){
    this.authService.registrar(this.formRegister.value).subscribe({
      next:(value:any)=>{
        console.log(value);
        this.router.navigate(["login"]);
      },
      error:(error) => {
        console.log(error);
      }

    })
  }

}
