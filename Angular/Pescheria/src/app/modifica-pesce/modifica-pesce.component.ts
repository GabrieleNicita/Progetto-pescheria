import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Categoria } from '../interfaces/Categoria';
import { Pesce } from '../interfaces/Pesce';
import { PesceMagazzino } from '../interfaces/PesceMagazzino';
import { Trattamento } from '../interfaces/Trattamento';
import { CategorieService } from '../services/categorie.service';
import { PesceService } from '../services/pesce.service';
import { TrattamentoService } from '../services/trattamento.service';

@Component({
  selector: 'app-modifica-pesce',
  templateUrl: './modifica-pesce.component.html',
  styleUrls: ['./modifica-pesce.component.css']
})
export class ModificaPesceComponent {

  @Output() modificato= new EventEmitter()

  @Input() recordModifica={
    id:0,
    nome:"",
    categoria:"",
    trattamento:"",
    prezzo:0,
    descrizione:""
  } as PesceMagazzino

  formModifica:FormGroup
  categoria:Categoria[]=new Array()
  trattamento:Trattamento[]=new Array()

  trattRec:Trattamento={
    id:0,
    trattamento:""
  }

  constructor(
    private categoriaSer:CategorieService,
    private fb:FormBuilder,
    private trattamentoSer:TrattamentoService) 
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
    
    ngOnChanges(){
      

      this.trattamentoSer.trattamento(this.recordModifica.trattamento).subscribe(tr=>{
        this.trattRec=tr
        console.log("cambio")

        this.formModifica=this.fb.group({
          nome:[this.recordModifica.nome,Validators.required],
          categoria:["",Validators.required],
          trattamento:["",Validators.required],
          descrizione:[this.recordModifica.descrizione,Validators.required],
          prezzoAlKg:[this.recordModifica.prezzo,Validators.required],
        })
      })
    }

    subModifica(){
      /*const pesce={
        nome:this.formModifica.value.nome,
        categoria:this.formModifica.value.categoria,
        trattamento:this.formModifica.value.trattamento,
        descrizione:this.formModifica.value.descrizione,
        prezzo:{
          prezzoAlKg:this.formModifica.value.prezzoAlKg
        }
      } 
      this.pesceServ.aggiungiPesce(pesce as Pesce)*/
      this.modificato.emit("submit")
    }
}

   



