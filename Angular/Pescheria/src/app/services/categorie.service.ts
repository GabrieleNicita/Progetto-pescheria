import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient} from '@angular/common/http';
import { Categoria } from '../interfaces/Categoria';

@Injectable({
  providedIn: 'root'
})
export class CategorieService {

  categorieURL:string
  localhost="localhost"
  host="192.168.88.249"

  constructor(private http: HttpClient) {
    this.categorieURL="http://"+this.host+":8080"+"/Categorie/"
  }

  public listaCategorie():Observable <Categoria[]>{
    return this.http.get<Categoria[]>(this.categorieURL)
  }
}
