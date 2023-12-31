import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class MyCustomInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {

    let requestToClone = request

    if(localStorage.getItem("session")){
      requestToClone = request.clone({
        setHeaders: {
          Authorization:"Bearer " + localStorage.getItem("session")!
        }
      })

    }

    return next.handle(requestToClone);
  }
}
