import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CatalogoComponent } from './catalogo/catalogo.component';
import { FotoUploadComponent } from './foto-upload/foto-upload.component';
import { HomeComponent } from './home/home.component';
import { MagazzinoComponent } from './magazzino/magazzino.component';

const routes: Routes = [
  {path: 'home',component:HomeComponent},
  {path: 'magazzino',component:MagazzinoComponent},
  {path: 'catalogo',component:CatalogoComponent},
  {path: 'fileupl',component:FotoUploadComponent},
  { path: '',redirectTo: '/home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
