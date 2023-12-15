import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { TipoContribuyenteService } from 'src/app/services/tipocontribuyente/tipo-contribuyente.service';
import { TipoDocumentoService } from 'src/app/services/tipodocumento/tipo-documento.service';

@Component({
  selector: 'app-tipo-documento-create',
  templateUrl: './tipo-documento-create.component.html',
  styleUrls: ['./tipo-documento-create.component.css']
})
export class TipoDocumentoCreateComponent {

  formTipoDocumento: FormGroup = this.formBuilder.group({
    nombre: (""),
    descripcion: ("")
  })


  constructor(private formBuilder: FormBuilder, private tipoDocumentoService:TipoDocumentoService, private router: Router){}


  agregar(){
    this.tipoDocumentoService.save(this.formTipoDocumento.value).subscribe({
      next:(value:any)=>{
        this.router.navigate(['tipodocumento'])
      },
      error:(error) => {
        console.log(error);
      }

    })
  }
  
}
