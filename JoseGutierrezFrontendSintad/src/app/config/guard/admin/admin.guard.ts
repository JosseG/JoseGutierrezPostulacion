import { inject } from '@angular/core';
import { CanActivateChildFn, Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication/authentication.service';

export const adminGuard: CanActivateChildFn = (route, state) => {

return true;
 
};
