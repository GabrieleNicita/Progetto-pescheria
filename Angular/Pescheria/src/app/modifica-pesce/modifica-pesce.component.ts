import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Categoria } from '../interfaces/Categoria';
import { modificaPesce } from '../interfaces/ModificaPesce';
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

  trattRecord=""
  categRecord=""

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
        nome:[Validators.required],
        categoria:[Validators.required],
        trattamento:[Validators.required],
        descrizione:[Validators.required],
        prezzoAlKg:[Validators.required],
      })
      
    }
    
    ngOnChanges(){
      
        this.formModifica=this.fb.group({
          nome:[this.recordModifica.nome,Validators.required],
          categoria:[this.recordModifica.categoria,Validators.required],
          trattamento:[this.recordModifica.trattamento,Validators.required],
          descrizione:[this.recordModifica.descrizione,Validators.required],
          prezzoAlKg:[this.recordModifica.prezzo,Validators.required],
          
        })
    
    }

    subModifica(){
      if(!this.formModifica.invalid){
      const modificaPesce={
        pesce:{
           id:this.recordModifica.id,
           nome:this.formModifica.value.nome,
           descrizione:this.formModifica.value.descrizione,
          },
        categorie:{
          categoria:this.formModifica.value.categoria
        },
        trattamenti:{
          trattamento:this.formModifica.value.trattamento
        },
        prezzi:{
          prezzoAlKg:this.formModifica.value.prezzoAlKg
        }

      } as modificaPesce

      
      this.pesceServ.modificaPesce(modificaPesce)
      
      this.modificato.emit("submit")
    }}
}

   



