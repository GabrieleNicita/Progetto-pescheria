import {Component} from '@angular/core';
import { Pesce } from '../interfaces/Pesce';
import { PesceService } from '../services/pesce.service';
import {ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-magazzino',
  templateUrl: './magazzino.component.html',
  styleUrls: ['./magazzino.component.css']
})
export class MagazzinoComponent {
  
   displayedColumns: string[]= ['id','nome','categoria.categoria','trattamento.trattamento','prezzo.prezzoAlKg'];
   dataSource= new MatTableDataSource<Pesce>();
   
   @ViewChild(MatPaginator) paginator: MatPaginator |any ;
  
  constructor(private pesciSer:PesceService){
 
   
    this.pesciSer.listaPesce().subscribe(ps=>{ 
       this.dataSource.paginator = this.paginator; 
       this.dataSource.data=ps;
    })
  }
}









