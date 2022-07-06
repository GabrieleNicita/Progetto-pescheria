import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient} from '@angular/common/http';
import { Categoria } from '../interfaces/Categoria';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CategorieService {

  categorieURL:string
  

  constructor(private http: HttpClient) {
    this.categorieURL="http://"+environment.host+":8080"+"/Categorie/"
  }

  public listaCategorie():Observable <Categoria[]>{
    return this.http.get<Categoria[]>(this.categorieURL)
  }
}
