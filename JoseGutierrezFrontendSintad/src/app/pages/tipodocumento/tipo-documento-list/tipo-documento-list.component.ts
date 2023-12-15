import { Component, inject } from '@angular/core';
import { TipoDocumentoService } from 'src/app/services/tipodocumento/tipo-documento.service';

@Component({
  selector: 'app-tipo-documento-list',
  templateUrl: './tipo-documento-list.component.html',
  styleUrls: ['./tipo-documento-list.component.css']
})
export class TipoDocumentoListComponent {


  private tipoDocumentoService = inject(TipoDocumentoService);

  tipoDocumentos : any[] = []

  
  ngOnInit(): void {
   this.obtenerTipoDocumentos();
  }


  private obtenerTipoDocumentos(){
    this.tipoDocumentoService.findAll().subscribe({
      next:(value) => {
        this.tipoDocumentos = value.content
      },
      error:(error) => {
        console.log(error)
      }
    })
  }

  activar(id:number){
    this.tipoDocumentoService.activar(id).subscribe({
      next:(value:any) => {
        this.obtenerTipoDocumentos();
      }
    })
    
  }
  desactivar(id:number){
    this.tipoDocumentoService.desactivar(id).subscribe({
      next:(value:any) => {
        this.obtenerTipoDocumentos();
      }
    })
  }
}
