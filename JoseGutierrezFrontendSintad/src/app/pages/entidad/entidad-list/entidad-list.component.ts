import { Component, OnInit, inject } from '@angular/core';
import { EntidadService } from 'src/app/services/entidad/entidad.service';

@Component({
  selector: 'app-entidad-list',
  templateUrl: './entidad-list.component.html',
  styleUrls: ['./entidad-list.component.css']
})
export class EntidadListComponent implements OnInit {
  private entidadService = inject(EntidadService);

  entidades : any[] = []

  
  ngOnInit(): void {
   this.obtenerEntidades();
  }


  private obtenerEntidades(){
    this.entidadService.findAll().subscribe({
      next:(value:any) => {
        this.entidades = value.content
        console.log(value);
      },
      error:(error) => {
        console.log(error)
      }
    })
  }

  activar(id:number){
    console.log("Activando");
    this.entidadService.activar(id).subscribe({
      next:(value:any) => {
        this.obtenerEntidades();
      }
    })
    
  }
  desactivar(id:number){
    console.log("Desactivando");
    this.entidadService.desactivar(id).subscribe({
      next:(value:any) => {
        this.obtenerEntidades();
      }
    })
  }

}
