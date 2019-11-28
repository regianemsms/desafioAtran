import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Location } from '@angular/common';
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
  ) { }

  ngOnInit() {
    this.formulario = this.createForm();
    this.service.insert('teste', this.formulario);
  }

  private createForm(): FormGroup {
    return this.formBuilder.group({
      id: [null],
      nome: [null],
      email: [null],
    });
  }

  salvar(){

    this.location.back();
  }
}
