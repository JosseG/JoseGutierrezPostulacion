import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { TipoContribuyenteService } from 'src/app/services/tipocontribuyente/tipo-contribuyente.service';

@Component({
  selector: 'app-tipo-contribuyente-create',
  templateUrl: './tipo-contribuyente-create.component.html',
  styleUrls: ['./tipo-contribuyente-create.component.css']
})
export class TipoContribuyenteCreateComponent {
  
  formTipoContribuyente: FormGroup = this.formBuilder.group({
    nombre: ("")
  })


  constructor(private formBuilder: FormBuilder, private tipoContribuyenteService:TipoContribuyenteService, private router: Router){}


  agregar(){
    this.tipoContribuyenteService.save(this.formTipoContribuyente.value).subscribe({
      next:(value:any)=>{
        this.router.navigate(['tipocontribuyente'])
      },
      error:(error) => {
        console.log(error);
      }

    })
  }
}
