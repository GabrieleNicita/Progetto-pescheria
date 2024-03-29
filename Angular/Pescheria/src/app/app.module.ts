import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {MatToolbarModule} from '@angular/material/toolbar';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';
import { CatalogoComponent } from './catalogo/catalogo.component';
import { HttpClientModule } from '@angular/common/http';
import { InserimentoPesceComponent } from './inserimento-pesce/inserimento-pesce.component';
import {MatFormFieldModule} from '@angular/material/form-field'; 
import { ReactiveFormsModule } from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select'; 
import {MatButtonModule} from '@angular/material/button';
import { MagazzinoComponent } from './magazzino/magazzino.component';
import {MatTableModule} from '@angular/material/table'
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import {MatIconModule} from '@angular/material/icon';
import { ElementRef } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ModificaPesceComponent } from './modifica-pesce/modifica-pesce.component';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CatalogoComponent,
    InserimentoPesceComponent,
    MagazzinoComponent,
    ModificaPesceComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatGridListModule,
    HttpClientModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule,
    MatTableModule,
    MatPaginatorModule,
    BrowserModule,
    MatTableModule,
    MatSortModule,
    MatIconModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
