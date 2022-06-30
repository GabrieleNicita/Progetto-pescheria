import { Component} from '@angular/core';
import { Categoria } from '../interfaces/Categoria';
import { CategorieService } from '../services/categorie.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-inserimento-pesce',
  templateUrl: './inserimento-pesce.component.html',
  styleUrls: ['./inserimento-pesce.component.css']
})
export class InserimentoPesceComponent{

  //formPesce:FormGroup
  categoria:Categoria[]=new Array()

  constructor(private categoriaSer:CategorieService,private fb:FormBuilder) { 
    this.categoriaSer.listaCategorie().subscribe(ct=>{(this.categoria =ct )})

    /*this.formPesce=this.fb.group({
      nome:["pesce",Validators.required],
      categoria:[Validators.required],
      trattamento:[Validators.required],
      prezzoAlKg:[Validators.required],
      descrizione:["",Validators.required]
    })*/

  }

  

}
