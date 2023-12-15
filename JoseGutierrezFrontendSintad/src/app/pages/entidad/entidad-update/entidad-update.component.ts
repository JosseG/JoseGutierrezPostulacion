import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { EntidadService } from 'src/app/services/entidad/entidad.service';
import { TipoContribuyenteService } from 'src/app/services/tipocontribuyente/tipo-contribuyente.service';
import { TipoDocumentoService } from 'src/app/services/tipodocumento/tipo-documento.service';

@Component({
  selector: 'app-entidad-update',
  templateUrl: './entidad-update.component.html',
  styleUrls: ['./entidad-update.component.css']
})
export class EntidadUpdateComponent {
  tipoContribuyentes: any[] = []

  formEntidad: FormGroup = this.formBuilder.group({
    id:(0),
    nroDocumento: (""),
    razonSocial: (""),
    nombreComercial: (""),
    direccion: (""),
    telefono: (""),
    idTipoDocumento: (0),
    idTipoContribuyente: (0)
  })


  constructor(private formBuilder: FormBuilder, private entidadService: EntidadService, private router: Router, private route:ActivatedRoute) { }


  actualizar() {

    console.log(this.formEntidad.value)

    this.entidadService.update(this.formEntidad.value).subscribe({
      next: (value: any) => {
        console.log(value)
        this.router.navigate(['entidad'])
      },
      error: (error) => {
        console.log(error);
      }

    })
  }


  private tipoDocumentoService = inject(TipoDocumentoService);

  tipoDocumentos: any[] = []


  ngOnInit(): void {

    this.route.paramMap.subscribe({
      next:(value:any) =>{
        console.log(value);
        
        this.entidadService.findById(parseInt(value.params.id)).subscribe({
          next:(entidad:any) => {
            console.log(entidad);
            
            this.formEntidad.patchValue(entidad.content[0]);
          }
        });
        console.log(value.params.id);
        
      }
    })


    this.obtenerTipoDocumentos();
    this.obtenerTipoContribuyentes();
  }


  private obtenerTipoDocumentos() {
    this.tipoDocumentoService.findAll().subscribe({
      next: (value) => {
        this.tipoDocumentos = value.content
        console.log(value);
      },
      error: (error) => {
        console.log(error)
      }
    })
  }
  private tipoContribuyenteService = inject(TipoContribuyenteService);




  private obtenerTipoContribuyentes() {
    this.tipoContribuyenteService.findAll().subscribe({
      next: (value) => {
        this.tipoContribuyentes = value.content
        console.log(value);
      },
      error: (error) => {
        console.log(error)
      }
    })
  }

}
