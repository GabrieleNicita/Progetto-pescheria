import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient} from '@angular/common/http';
import { Pesce } from '../interfaces/Pesce';
@Injectable({
  providedIn: 'root'
})
export class PesceService {
  pesciURL:string
  localhost="localhost"
  host="192.168.88.249"
  constructor(private http: HttpClient) { 
    this.pesciURL="http://"+this.host+":8080"+"/Pesci/"
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

}
