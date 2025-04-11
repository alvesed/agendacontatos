import { Injectable } from '@angular/core';
import { Contato } from '../model/contato';
import { HttpClient } from '@angular/common/http';
import { delay, first, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ContatosService {
  API_URL = 'http://localhost:8080/agendacontatos';

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<Contato[]>(this.API_URL)
      .pipe(
        first(),
        tap((contatos: Contato[]) => console.log('Contatos:', contatos)),
      );
  }

  save(contato: Contato) {
    return this.httpClient.post<Contato>(this.API_URL, contato)
      .pipe(
        first(),
        tap((contato: Contato) => console.log('Contato salvo:', contato)),
      );
  }

}
