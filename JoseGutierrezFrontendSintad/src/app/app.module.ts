import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, HttpClient, HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './pages/login/login.component';
import { EntidadListComponent } from './pages/entidad/entidad-list/entidad-list.component';
import { EntidadCreateComponent } from './pages/entidad/entidad-create/entidad-create.component';
import { EntidadUpdateComponent } from './pages/entidad/entidad-update/entidad-update.component';
import { TipoDocumentoListComponent } from './pages/tipodocumento/tipo-documento-list/tipo-documento-list.component';
import { TipoDocumentoCreateComponent } from './pages/tipodocumento/tipo-documento-create/tipo-documento-create.component';
import { TipoDocumentoUpdateComponent } from './pages/tipodocumento/tipo-documento-update/tipo-documento-update.component';
import { TipoContribuyenteListComponent } from './pages/tipocontribuyente/tipo-contribuyente-list/tipo-contribuyente-list.component';
import { TipoContribuyenteCreateComponent } from './pages/tipocontribuyente/tipo-contribuyente-create/tipo-contribuyente-create.component';
import { TipoContribuyenteUpdateComponent } from './pages/tipocontribuyente/tipo-contribuyente-update/tipo-contribuyente-update.component';
import { RegisterComponent } from './pages/register/register.component';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { MyCustomInterceptor } from './config/interceptor/my-custom.interceptor';
import { NavbarComponent } from './components/navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EntidadListComponent,
    EntidadCreateComponent,
    EntidadUpdateComponent,
    TipoDocumentoListComponent,
    TipoDocumentoCreateComponent,
    TipoDocumentoUpdateComponent,
    TipoContribuyenteListComponent,
    TipoContribuyenteCreateComponent,
    TipoContribuyenteUpdateComponent,
    RegisterComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    {
      provide:HTTP_INTERCEPTORS,
      useClass: MyCustomInterceptor,
      multi:true
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
