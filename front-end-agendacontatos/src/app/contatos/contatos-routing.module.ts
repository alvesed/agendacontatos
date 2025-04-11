import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContatoFormComponent } from './contato-form/contato-form.component';

const routes: Routes = [
  { path: 'new', component: ContatoFormComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ContatosRoutingModule { }
