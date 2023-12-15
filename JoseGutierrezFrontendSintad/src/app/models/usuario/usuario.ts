import { Rol } from "../rol/rol";

export class Usuario {

    id:number;
    username:string;
    password:string;
    estado:boolean;
    rol:Rol;

    constructor(){
        this.id = 0;
        this.username = "";
        this.password = "";
        this.estado = false;
        this.rol = new Rol();
    }

}
