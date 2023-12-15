import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EntidadListComponent } from './pages/entidad/entidad-list/entidad-list.component';
import { LoginComponent } from './pages/login/login.component';
import { EntidadCreateComponent } from './pages/entidad/entidad-create/entidad-create.component';
import { EntidadUpdateComponent } from './pages/entidad/entidad-update/entidad-update.component';
import { RegisterComponent } from './pages/register/register.component';
import { asistenteGuard } from './config/guard/asistente/asistente.guard';
import { adminGuard } from './config/guard/admin/admin.guard';
import { TipoDocumentoListComponent } from './pages/tipodocumento/tipo-documento-list/tipo-documento-list.component';
import { TipoDocumentoCreateComponent } from './pages/tipodocumento/tipo-documento-create/tipo-documento-create.component';
import { TipoDocumentoUpdateComponent } from './pages/tipodocumento/tipo-documento-update/tipo-documento-update.component';
import { TipoContribuyenteListComponent } from './pages/tipocontribuyente/tipo-contribuyente-list/tipo-contribuyente-list.component';
import { TipoContribuyenteUpdateComponent } from './pages/tipocontribuyente/tipo-contribuyente-update/tipo-contribuyente-update.component';
import { TipoContribuyenteCreateComponent } from './pages/tipocontribuyente/tipo-contribuyente-create/tipo-contribuyente-create.component';

const routes: Routes = [
  {
    path: '', pathMatch: 'full', redirectTo: 'entidad'
  },
  {
    path: 'entidad', 
    component: EntidadListComponent,
    canActivate:[asistenteGuard],
  },
  {
    path:'entidad/create',component:EntidadCreateComponent
  },
  {
    path:'entidad/update/:id',component:EntidadUpdateComponent
  },
  {
    path: 'tipodocumento', 
    component: TipoDocumentoListComponent,
    canActivate:[asistenteGuard],
  },
  {
    path:'tipodocumento/create',component:TipoDocumentoCreateComponent
  },
  {
    path:'tipodocumento/update/:id',component:TipoDocumentoUpdateComponent
  },
  {
    path: 'tipocontribuyente', 
    component: TipoContribuyenteListComponent,
    canActivate:[asistenteGuard]
  },
  {
    path:'tipocontribuyente/create',component:TipoContribuyenteCreateComponent
  },
  {
    path:'tipocontribuyente/update/:id',component:TipoContribuyenteUpdateComponent
  },
  {
    path: 'login', component: LoginComponent
  },
  {
    path: 'register', component: RegisterComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
