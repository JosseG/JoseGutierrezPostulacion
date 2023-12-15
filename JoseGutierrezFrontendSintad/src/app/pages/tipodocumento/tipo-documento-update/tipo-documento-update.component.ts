import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TipoDocumentoService } from 'src/app/services/tipodocumento/tipo-documento.service';

@Component({
  selector: 'app-tipo-documento-update',
  templateUrl: './tipo-documento-update.component.html',
  styleUrls: ['./tipo-documento-update.component.css']
})
export class TipoDocumentoUpdateComponent implements OnInit {


  formTipoDocumento: FormGroup = this.formBuilder.group({
    id:(0),
    nombre: (""),
    descripcion: ("")
  })


  constructor(private formBuilder: FormBuilder, private tipoDocumentoService:TipoDocumentoService, private router: Router, private route:ActivatedRoute){}

  ngOnInit(): void {
    this.route.paramMap.subscribe({
      next:(value:any) =>{
        console.log(value);
        
        this.tipoDocumentoService.findById(parseInt(value.params.id)).subscribe({
          next:(tipodocumento:any) => {
            console.log(tipodocumento)
            this.formTipoDocumento.patchValue(tipodocumento.content[0]);
          },
          error:(errorTipodoc) => {
            console.log(errorTipodoc);
          }
        });
        
      },
      error:(error) => {
        console.log(error);
      }
    })
  }


  actualizar(){
    this.tipoDocumentoService.update(this.formTipoDocumento.value).subscribe({
      next:(value:any)=>{
        console.log(value)
        this.router.navigate(['tipodocumento'])
      },
      error:(error) => {
        console.log(error);
      }

    })
  }
}
