import { Component, EventEmitter, Output } from '@angular/core';
import { Categoria } from '../interfaces/Categoria';
import { CategorieService } from '../services/categorie.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TrattamentoService } from '../services/trattamento.service';
import { Trattamento } from '../interfaces/Trattamento';
import { Pesce } from '../interfaces/Pesce';
import { PesceService } from '../services/pesce.service';

@Component({
  selector: 'app-inserimento-pesce',
  templateUrl: './inserimento-pesce.component.html',
  styleUrls: ['./inserimento-pesce.component.css']
})
export class InserimentoPesceComponent {
  @Output() inserito= new EventEmitter()

  imgFD = new FormData()
  formPesce:FormGroup
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

    this.formPesce=this.fb.group({
      nome:["",Validators.required],
      categoria:["",Validators.required],
      trattamento:["",Validators.required],
      descrizione:["",Validators.required],
      prezzoAlKg:["",Validators.required],
      })
    } 

  imageSrc: string | any;

  onImageUpload(event: any){

    if (event.target.files && event.target.files[0]) {

      const pesce={
        nome:this.formPesce.value.nome,
        categoria:this.formPesce.value.categoria,
        trattamento:this.formPesce.value.trattamento,
        descrizione:this.formPesce.value.descrizione,
        prezzo:{
          prezzoAlKg:this.formPesce.value.prezzoAlKg
        }
        
      } as Pesce
        
        this.imgFD.append('image',event.target.files[0] as File,event.target.files[0].name)
        this.imgFD.append('cos',JSON.stringify(pesce))
        
      }
 
    }

  subPesce(){
    
    const pesce={
      nome:this.formPesce.value.nome,
      categoria:this.formPesce.value.categoria,
      trattamento:this.formPesce.value.trattamento,
      descrizione:this.formPesce.value.descrizione,
      prezzo:{
        prezzoAlKg:this.formPesce.value.prezzoAlKg
      }
      
    } 
    if(!this.formPesce.invalid){
    this.pesceServ.aggiungiPesce(pesce as Pesce)
    this.inserito.emit()
  }
}

}
