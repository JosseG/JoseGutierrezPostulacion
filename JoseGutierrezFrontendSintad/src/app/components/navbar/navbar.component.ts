import { Component, inject } from '@angular/core';
import { AuthenticationService } from '../../services/authentication/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  private authService = inject(AuthenticationService);
  private router = inject(Router);

  logout(){
    this.authService.logout().subscribe({
      next:(value:any) => {
        this.router.navigate(['login'])
      }
    });
  }


}
