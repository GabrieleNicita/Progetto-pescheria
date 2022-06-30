import {Component} from '@angular/core';
import { Pesce } from '../interfaces/Pesce';
import { PesceService } from '../services/pesce.service';
@Component({
  selector: 'app-magazzino',
  templateUrl: './magazzino.component.html',
  styleUrls: ['./magazzino.component.css']
})
export class MagazzinoComponent{
  pesce:Pesce[]=new Array()
   displayedColumns: string[]= ['id','nome','categoria.categoria','trattamento.trattamento','prezzo.prezzoAlKg'];
   dataSource:any;
 
  constructor(private pesciSer:PesceService){
    this.pesciSer.listaPesce().subscribe(ps=>{(this.pesce=ps)
       this.dataSource = this.pesce;
    })
  }
}









