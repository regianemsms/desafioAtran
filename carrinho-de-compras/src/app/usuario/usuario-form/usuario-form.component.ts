import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CrudService } from 'src/app/services/crud.service';

@Component({
  selector: 'app-usuario',
  templateUrl: 'usuario-form.component.html',
  styleUrls: ['usuario-form.component.css']
})
export class UsuarioComponent implements OnInit {
  formulario: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private location: Location,
    private service: CrudService
  ) {}

  ngOnInit() {
    this.formulario = this.createForm();
  }

  private createForm(): FormGroup {
    return this.formBuilder.group({
      id: [null],
      nome: [null],
      email: [null],
      carrinho: [null]
    });
  }
  salvar() {
    this.service.insert('usuario', this.formulario.value).subscribe(
      data => {
         console.log(data);
      },
      err => {
        console.log(err);
      }
    );
  //this.location.back();
  }

  listar() {
    this.service.list('usuario').subscribe(
      data => console.log(data),
      err => console.log(err)
    );
  }
}
