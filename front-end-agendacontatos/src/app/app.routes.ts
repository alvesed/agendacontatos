import { Routes } from '@angular/router';
import { ContatosComponent } from './contatos/contatos/contatos.component';
import { ContatoFormComponent } from './contatos/contato-form/contato-form.component';

export const routes: Routes = [
    { path: '', pathMatch: 'full', redirectTo: 'contatos' },
    {path: 'contatos', component: ContatosComponent},
    {path: 'contatos/new', component: ContatoFormComponent},
];
