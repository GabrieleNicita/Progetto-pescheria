import { Component, ViewChild, ElementRef } from '@angular/core';
import { Pesce } from '../interfaces/Pesce';
import { PesceService } from '../services/pesce.service';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import { LiveAnnouncer } from '@angular/cdk/a11y';
import { MatSort, Sort } from '@angular/material/sort';
import { MatInput } from '@angular/material/input';
import {DomSanitizer} from '@angular/platform-browser';
import {MatIconRegistry} from '@angular/material/icon';
import * as XLSX from 'xlsx';
import { QueryList } from '@angular/core';
import { ViewChildren } from '@angular/core';
import { PesceMagazzino } from '../interfaces/PesceMagazzino';
import { NgModule,Input }  from '@angular/core';

const THUMBUP_ICON =
  `
<svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 1000 1000" enable-background="new 0 0 1000 1000" xml:space="preserve">
<metadata> Svg Vector Icons : http://www.onlinewebfonts.com/icon </metadata>
<g><path d="M774.6,990.1H71.1c-33.8,0-61.1-27.4-61.1-61.2V163.5c0-33.8,27.3-61.2,61.1-61.2h490l1.6,1.6l-61.8,59.7H71.1v765.4h703.5V539l61.2-58.5v448.4C835.8,962.8,808.4,990.1,774.6,990.1L774.6,990.1z M943.9,245.2C913.7,276.3,541,643.6,521.7,662.7c-3,2.9-6.7,5.1-10.7,6.3c-30.6,9.1-216.6,69.3-218.4,70c-2.6,0.8-5.2,1.2-7.9,1.2c-6.7,0-13.2-2.6-18.1-7.5c-6.8-6.7-9.4-16.8-6.5-26.1c0.5-1.8,55.6-182.1,66.6-222.8c1.1-4.4,3.5-8.4,6.6-11.6c0,0,405.5-405.3,419.8-419.4c10.1-10.1,47.2-43,98.1-43c32.5,0,62.9,13.4,90.6,39.9c31.3,30.1,47.6,62.3,48.2,95.8C990.6,179.5,975.1,212.9,943.9,245.2L943.9,245.2z M899.5,94c-16-15.4-31.8-22.9-48.2-22.9c-28.9,0-52.3,22.5-54.9,25.1C783.1,109.3,435.7,456.4,383.2,509c-8.8,31-28.5,96.6-44.9,150.9c51-16.5,118.5-38.2,146.7-46.9l18.8-18.5C749.7,352,882.9,220.1,899.9,202.6c19.4-20.1,29.1-38.9,28.8-55.9C928.6,130.1,918.6,112.4,899.5,94L899.5,94z"/></g>
</svg>
`;
@Component({
  selector: 'app-magazzino',
  templateUrl: './magazzino.component.html',
  styleUrls: ['./magazzino.component.css']
})

export class MagazzinoComponent {
  
  tabella:PesceMagazzino[]
  operazione:string
  form:boolean

   displayedColumns: string[]= ['id','nome','categoria','trattamento','prezzo','azioni'];
   dataSource= new MatTableDataSource<PesceMagazzino>();

   @ViewChild('TABLE',{ read: ElementRef }) table: ElementRef |any; 
   @ViewChild(MatPaginator) paginator: MatPaginator |any ;
   @ViewChild(MatSort) sort: MatSort |any;
   @ViewChildren(MatInput,{read:ElementRef}) inputs:QueryList<ElementRef> |any;
   editRowId:any
   
  constructor(
    private pesciSer:PesceService,
    private _liveAnnouncer: LiveAnnouncer,
    iconRegistry: MatIconRegistry, 
    sanitizer: DomSanitizer,
    private pesceServ:PesceService
    ){
    
    this.table as ElementRef
    this.tabella=new Array()
    this.form=false
    this.operazione="inserisci Opesce"

    iconRegistry.addSvgIconLiteral('thumbs-up', sanitizer.bypassSecurityTrustHtml(THUMBUP_ICON));
    
    
    
    this.pesciSer.listaPesce().subscribe(
      ps=>{  
        ps.forEach(
          p => {
                  this.dataSource.data.push({
                    id:p.id,
                    nome:p.nome,
                    categoria:p.categoria.categoria,
                    trattamento:p.trattamento.trattamento,
                    prezzo:p.prezzo.prezzoAlKg,
                    descrizione:p.descrizione,
                    })
                });
       this.dataSource.sort = this.sort;
       this.dataSource.paginator = this.paginator;                 
        }
      )
    
  }




 exportAsExcel()
  {
   
    
    const ws: XLSX.WorkSheet=XLSX.utils.table_to_sheet(this.table.nativeElement);
    
   
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'Foglio');
    
    
   XLSX.writeFile(wb,'Foglio.xlsx');
    console.log("exported");

  }

  announceSortChange(sortState: Sort) {
    
    if (sortState.direction) {
      this._liveAnnouncer.announce(`Sorted ${sortState.direction}ending`);
    } else {
      this._liveAnnouncer.announce('Sorting cleared');
    }
  }
  
  inserimentoForm(){
      if(this.form){

      window.location.reload()
      this.form=false
      this.operazione="NUOVO PESCE"
      }
      else{
      this.form=true
      this.operazione="ANNULLA"
      }
    }
    alert(id:number){
      
      if(confirm("SEI SICURO DI VOLER CANCELLARE QUESTO ELEMENTO")) {
        this.pesceServ.rimuoviPesce(id);
        window.location.reload()
        
    }
} 
 /*
  edit(row:any,element:any)
  {
    this.editRowId=row;
   
    setTimeout(()=>{this.inputs.find(x=>{ x.nativeElement.getAttribute('prezzoAlKilo')==element})
   .nativeElement.focus()
    })
  }*/



}
