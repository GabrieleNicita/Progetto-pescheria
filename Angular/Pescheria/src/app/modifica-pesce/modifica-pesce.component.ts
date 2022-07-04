import { Component
 } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Categoria } from '../interfaces/Categoria';
import { Trattamento } from '../interfaces/Trattamento';
import { CategorieService } from '../services/categorie.service';
import { PesceService } from '../services/pesce.service';
import { TrattamentoService } from '../services/trattamento.service';

@Component({
  selector: 'app-modifica-pesce',
  templateUrl: './modifica-pesce.component.html',
  styleUrls: ['./modifica-pesce.component.css']
})
export class ModificaPesceComponent{

  formModifica:FormGroup
  categoria:Categoria[]=new Array()
  trattamento:Trattamento[]=new Array()

  constructor(
    private categoriaSer:CategorieService,
    private fb:FormBuilder,
    private trattamentoSer:TrattamentoService,
    private pesceServ:PesceService) 

    {
      this.categoriaSer.listaCategorie().subscribe(

        ct=>{(this.categoria =ct )

        this.trattamentoSer.listaTrattamenti().subscribe(tr=>{(this.trattamento =tr )})
      })

      this.formModifica=this.fb.group({
        nome:["",Validators.required],
        categoria:["",Validators.required],
        trattamento:["",Validators.required],
        descrizione:["",Validators.required],
        prezzoAlKg:[0,Validators.required],
        })
      
    }
    subModifica(){

      
    }
}


