import { Routes } from '@angular/router';
import { ContatosComponent } from './contatos/contatos/contatos.component';

export const routes: Routes = [
    { path: '', pathMatch: 'full', redirectTo: 'contatos' },
    {path: 'contatos', component: ContatosComponent},
];
