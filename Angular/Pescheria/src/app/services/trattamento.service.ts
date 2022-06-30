import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Trattamento } from '../interfaces/Trattamento';

@Injectable({
  providedIn: 'root'
})
export class TrattamentoService {

  trattamentiURL:string
  localhost="localhost"
  host="192.168.88.249"

  constructor(private http: HttpClient) {
    this.trattamentiURL="http://"+this.host+":8080"+"/Trattamenti/"
  }

  public listaTrattamenti():Observable<Trattamento[]>{
    return this.http.get<Trattamento[]>(this.trattamentiURL)
  }

}
