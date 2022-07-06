import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient,HttpEventType} from '@angular/common/http';
import { Pesce } from '../interfaces/Pesce';
import { modificaPesce } from '../interfaces/ModificaPesce';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})

export class PesceService {

  pesciURL:string
  constructor(private http: HttpClient) { 
      this.pesciURL="http://"+environment.host+":8080"+"/Pesci/"
    }
    

  public listaPesce():Observable <Pesce[]>{
    return this.http.get<Pesce[]>(this.pesciURL)
  }

  public aggiungiPesce(formP:Pesce){
    const headers={'content-type':'application/json'} 
    this.http.post(this.pesciURL+'Aggiungi',JSON.stringify(formP),{'headers':headers}).subscribe();
  }

  public rimuoviPesce(idPesce:number){
    this.http.delete(this.pesciURL+"Cancella/"+idPesce).subscribe();
  }

  public modificaPrezzo(idPesce:number,prezzoPesce:number){
    this.http.get(this.pesciURL+"Modifica/"+idPesce+"/"+prezzoPesce).subscribe()
  }

  public modificaPesce(pesceModifica:modificaPesce){
    const headers={'content-type':'application/json'}
    this.http.put<Pesce>(this.pesciURL+"Modifica",JSON.stringify(pesceModifica) , {'headers':headers}).subscribe(mdP=>console.log(mdP))
  }

  public uploadP(){}

}
