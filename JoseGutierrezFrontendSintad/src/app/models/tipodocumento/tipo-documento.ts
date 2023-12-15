export class TipoDocumento {

    id:number;
    codigo:string;
    nombre:string;
    descripcion:string;
    estado:boolean;

    constructor(){
        this.id = 0;
        this.codigo = "";
        this.nombre = "";
        this.descripcion = "";
        this.estado = false;
    }

}
