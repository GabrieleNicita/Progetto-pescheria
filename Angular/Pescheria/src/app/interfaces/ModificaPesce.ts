import { Categoria } from "./Categoria";
import { Pesce } from "./Pesce";
import { Prezzo } from "./Prezzo";
import { Trattamento } from "./Trattamento";

export interface modificaPesce{
    pesce:Pesce,
    prezzi:Prezzo,
    categorie:Categoria,
    trattamenti:Trattamento
    
}