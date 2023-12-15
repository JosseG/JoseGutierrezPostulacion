import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { EntidadService } from 'src/app/services/entidad/entidad.service';
import { TipoContribuyenteService } from 'src/app/services/tipocontribuyente/tipo-contribuyente.service';
import { TipoDocumentoService } from 'src/app/services/tipodocumento/tipo-documento.service';

@Component({
  selector: 'app-entidad-create',
  templateUrl: './entidad-create.component.html',
  styleUrls: ['./entidad-create.component.css']
})
export class EntidadCreateComponent {


  tipoContribuyentes: any[] = []

  formEntidad: FormGroup = this.formBuilder.group({
    nroDocumento: (""),
    razonSocial: (""),
    nombreComercial: (""),
    direccion: (""),
    telefono: (""),
    idTipoDocumento: (0),
    idTipoContribuyente: (0)
  })


  constructor(private formBuilder: FormBuilder, private entidadService: EntidadService, private router: Router) { }


  agregar() {

    console.log(this.formEntidad.value)

    this.entidadService.save(this.formEntidad.value).subscribe({
      next: (value: any) => {
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
