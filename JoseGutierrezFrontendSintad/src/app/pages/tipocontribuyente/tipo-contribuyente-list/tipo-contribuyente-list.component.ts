import { Component, inject } from '@angular/core';
import { TipoContribuyenteService } from 'src/app/services/tipocontribuyente/tipo-contribuyente.service';

@Component({
  selector: 'app-tipo-contribuyente-list',
  templateUrl: './tipo-contribuyente-list.component.html',
  styleUrls: ['./tipo-contribuyente-list.component.css']
})
export class TipoContribuyenteListComponent {

  private tipoContribuyenteService = inject(TipoContribuyenteService);

  tipoContribuyentes : any[] = []

  
  ngOnInit(): void {
   this.obtenerTipoContribuyentes();
  }


  private obtenerTipoContribuyentes(){
    this.tipoContribuyenteService.findAll().subscribe({
      next:(value) => {
        this.tipoContribuyentes = value.content
        console.log(value);
      },
      error:(error) => {
        console.log(error)
      }
    })
  }
  activar(id:number){
    console.log("Activando");
    this.tipoContribuyenteService.activar(id).subscribe({
      next:(value:any) => {
        this.obtenerTipoContribuyentes();
      }
    })
    
  }
  desactivar(id:number){
    console.log("Desactivando");
    this.tipoContribuyenteService.desactivar(id).subscribe({
      next:(value:any) => {
        this.obtenerTipoContribuyentes();
      }
    })
  }


}
