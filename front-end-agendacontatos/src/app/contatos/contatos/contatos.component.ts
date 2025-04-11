import { Component, OnInit } from '@angular/core';
import {MatTableModule} from '@angular/material/table';
import { Contato } from '../model/contato';
import { ContatosService } from '../services/contatos.service';
import { Observable, of } from 'rxjs';

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
  
  constructor(private contatoService: ContatosService) {
    //this.contatoService = new ContatosService();

    this.contatos = this.contatoService.list();
  }
  ngOnInit(): void {}
  
  displayedColumns: string[] = ['nome', 'cpf', 'actions'];

  onAdicionar() {
    console.log("Adicionando contato...");
  }
  onConsultar() {
    console.log("Consultar contato...");
  }
  onEditar() {
    console.log("Editar contato...");
  }
  onInativar() {
    console.log("Inativar contato...");
  }


}
