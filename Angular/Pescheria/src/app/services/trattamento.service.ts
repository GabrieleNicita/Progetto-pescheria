import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Trattamento } from '../interfaces/Trattamento';

@Injectable({
  providedIn: 'root'
})
export class TrattamentoService {

  trattamentiURL:string
 

  constructor(private http: HttpClient) {
    this.trattamentiURL="http://"+environment.host+":8080"+"/Trattamenti/"
  }

  public listaTrattamenti():Observable<Trattamento[]>{
    return this.http.get<Trattamento[]>(this.trattamentiURL)
  }

  public trattamento(nomeTrattamento:string):Observable <Trattamento>{
    return this.http.get<Trattamento>(this.trattamentiURL+":"+nomeTrattamento)
  }
}
