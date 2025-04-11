import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NonNullableFormBuilder, ReactiveFormsModule } from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { ContatosService } from '../services/contatos.service';
import { ActivatedRoute } from '@angular/router';
import { Contato } from '../model/contato';

@Component({
  selector: 'app-contato-form',
  imports: [MatFormFieldModule, MatInputModule, ReactiveFormsModule ],
  templateUrl: './contato-form.component.html',
  styleUrl: './contato-form.component.css',
  standalone: true
})
export class ContatoFormComponent {

  form!: FormGroup;

  constructor(private formBuilder: NonNullableFormBuilder,
    private service: ContatosService,
    private route: ActivatedRoute) {
      this.form = this.formBuilder.group({
        nome: [""],
        cpf: [""]
      });
  
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.form.value);
    this.service.save(this.form.value)
        .subscribe(result => console.log("sucesso"));
  }

  onCancel() {
    //this.location.back();
  }
}
