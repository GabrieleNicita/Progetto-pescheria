import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CatalogoComponent } from './catalogo/catalogo.component';
import { HomeComponent } from './home/home.component';
import { InserimentoPesceComponent } from './inserimento-pesce/inserimento-pesce.component';

const routes: Routes = [
  {path: 'home',component:HomeComponent},
  {path: 'catalogo',component:CatalogoComponent},
  {path: 'nuovo',component:InserimentoPesceComponent},
  { path: '',redirectTo: '/home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
