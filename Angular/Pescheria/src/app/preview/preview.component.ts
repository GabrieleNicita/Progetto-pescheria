import { Component, Input} from '@angular/core';
import { Pesce } from '../interfaces/Pesce';

@Component({
  selector: 'app-preview',
  templateUrl: './preview.component.html',
  styleUrls: ['./preview.component.css']
})
export class PreviewComponent{

  @Input() preview = {
    id:0,
    nome:'',
    categoria:{
      id:0,
    categoria:''
    },
    trattamento:{
      id:0,
      trattamento:''
    },
    prezzo:{
      id:0,
      prezzoAlKg:0
    },
    descrizione:'',
    foto:''
  } as Pesce;


  bool:boolean=false;
}
