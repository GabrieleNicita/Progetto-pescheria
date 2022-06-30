import { Component} from '@angular/core';
import { Categoria } from '../interfaces/Categoria';
import { CategorieService } from '../services/categorie.service';

@Component({
  selector: 'app-catalogo',
  templateUrl: './catalogo.component.html',
  styleUrls: ['./catalogo.component.css']
})
export class CatalogoComponent{

  categoria:Categoria[]=new Array()

  constructor(private categoriaSer:CategorieService) { 
    
    this.categoriaSer.listaCategorie().subscribe(ct=>{(this.categoria =ct )})
    
  }


}
