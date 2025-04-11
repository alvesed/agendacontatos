import { Component, OnInit } from '@angular/core';
import {MatTableModule} from '@angular/material/table';
import { Contato } from '../model/contato';
import { ContatosService } from '../services/contatos.service';
import { Observable, of } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

@Component({
  selector: 'table-basic-example',
  templateUrl: './contatos.component.html',
  styleUrl: './contatos.component.css',
  imports: [MatTableModule],
})


export class ContatosComponent implements OnInit{
  contatos: Observable<Contato[]>;

  //contatoService: ContatosService;
  
  constructor(
    private contatoService: ContatosService,
    private router: Router
  ) {
    //this.contatoService = new ContatosService();

    this.contatos = this.contatoService.list();
  }
  ngOnInit(): void {}
  
  displayedColumns: string[] = ['nome', 'cpf', 'actions'];

  onAdicionar() {
    console.log("Adicionando contato...");
    this.router.navigate(['/contatos/new']);
  }
  onConsultar() {
    console.log("Consultar contato...");
    this.router.navigate(['/contatos/new']);
  }
  onEditar() {
    console.log("Editar contato...");
    this.router.navigate(['/contatos/new']);
  }
  onInativar() {
    console.log("Inativar contato...");
    this.router.navigate(['/contatos/new']);
  }


}
