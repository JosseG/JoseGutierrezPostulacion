import { TipoContribuyente } from "../tipocontribuyente/tipo-contribuyente";
import { TipoDocumento } from "../tipodocumento/tipo-documento";

export class Entidad {

    id: number;
    nroDocumento: string;
    razonSocial: string;
    nombreComercial: string;
    direccion: string;
    telefono: string;
    estado: boolean;
    tipoDocumento: TipoDocumento;
    tipoContribuyente: TipoContribuyente;

    constructor() {
        this.id = 0;
        this.nroDocumento = "";
        this.razonSocial = "";
        this.nombreComercial = "";
        this.direccion = "";
        this.telefono = "";
        this.estado = false;
        this.tipoDocumento = new TipoDocumento();
        this.tipoContribuyente = new TipoContribuyente();
    }

}

/*export class EntidadInsert {

    nroDocumento: string;
    razonSocial: string;
    nombreComercial: string;
    direccion: string;
    telefono: string;
    idTipoDocumento: number;
    idTipoContribuyente: number;

    constructor() {
        this.nroDocumento = "";
        this.razonSocial = "";
        this.nombreComercial = "";
        this.direccion = "";
        this.telefono = "";
        this.idTipoDocumento = 0;
        this.idTipoContribuyente = 0;
    }

}*/