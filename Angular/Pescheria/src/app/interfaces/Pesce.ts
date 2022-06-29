import { Categoria } from "./Categoria"

export interface Pesce{
    id:number
    nome:string
    categoria:Categoria
    prezzoAlKg:number
    descrizione:string
    foto:string
}