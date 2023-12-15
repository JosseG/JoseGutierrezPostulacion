import { CanActivateFn } from '@angular/router';

export const asistenteGuard: CanActivateFn = (route, state) => {
  return true;
};
