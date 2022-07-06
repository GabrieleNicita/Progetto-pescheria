import { Component } from '@angular/core';

@Component({
  selector: 'app-foto-upload',
  templateUrl: './foto-upload.component.html',
  styleUrls: ['./foto-upload.component.css']
})
export class FotoUploadComponent {


  fotoSel(foto:any){
    if(foto.target.files){
      console.log("ff")
      var reader=new FileReader()
      console.log(reader.readAsDataURL(foto.target.files[0]))
    }

  }

}
