import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TipoContribuyenteService } from 'src/app/services/tipocontribuyente/tipo-contribuyente.service';

@Component({
  selector: 'app-tipo-contribuyente-update',
  templateUrl: './tipo-contribuyente-update.component.html',
  styleUrls: ['./tipo-contribuyente-update.component.css']
})
export class TipoContribuyenteUpdateComponent implements OnInit {
  formTipoContribuyente: FormGroup = this.formBuilder.group({
    id:(0),
    nombre: ("")
  })


  constructor(private formBuilder: FormBuilder, private tipoContribuyenteService:TipoContribuyenteService, private router: Router,private route: ActivatedRoute){}


  ngOnInit(): void {
    this.route.paramMap.subscribe({
      next:(value:any) =>{
        console.log(value);
        
        this.tipoContribuyenteService.findById(parseInt(value.params.id)).subscribe({
          next:(tipoContribuyente:any) => {
            console.log(tipoContribuyente)
            this.formTipoContribuyente.patchValue(tipoContribuyente.content[0]);
          },
          error:(errorTipoContr) => {
            console.log(errorTipoContr);
          }
        });
        
      },
      error:(error) => {
        console.log(error);
      }
    })
  }


  actualizar(){
    this.tipoContribuyenteService.update(this.formTipoContribuyente.value).subscribe({
      next:(value:any)=>{
        console.log(value);
        this.router.navigate(['tipocontribuyente'])
      },
      error:(error) => {
        console.log(error);
      }

    })
  }
}
