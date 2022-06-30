import { Categoria } from "./Categoria"
import { Prezzo } from "./Prezzo"
import { Trattamento } from "./Trattamento"

export interface Pesce{
    id:number
    nome:string
    categoria:Categoria
    trattamento:Trattamento
    prezzoAlKg:Prezzo
    descrizione:string
}