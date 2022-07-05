import { Component} from '@angular/core';
import { Pesce } from '../interfaces/Pesce';
import { PesceService } from '../services/pesce.service';
@Component({
  selector: 'app-catalogo',
  templateUrl: './catalogo.component.html',
  styleUrls: ['./catalogo.component.css']
})
export class CatalogoComponent{

  pesci:Pesce[]=new Array()

  constructor(private pesciService:PesceService) { 
    
   pesciService.listaPesce().subscribe( ps=>{(this.pesci =ps )})
    

   
  }

 Pesci(){
  console.log(this.pesci);
 }
}
