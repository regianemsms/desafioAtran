import { Usuario } from './../../model/usuario.model';
import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { CrudService } from 'src/app/services/crud.service';
import { ActivatedRoute } from '@angular/router';
import {MessageService} from 'primeng/api';

@Component({
  selector: 'app-usuario',
  templateUrl: 'usuario-form.component.html',
  styleUrls: ['usuario-form.component.css']
})
export class UsuarioComponent implements OnInit {
  formulario: FormGroup;
  path: string = 'usuario';
  usuario: Usuario;
  emailPattern = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;

  constructor(
    private formBuilder: FormBuilder,
    private service: CrudService,
    private msgService: MessageService,
    private location: Location,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.formulario = this.createForm();
    this.updateVerify();
  }

  updateVerify(){
    const id = this.activatedRoute.snapshot.paramMap.get('id');
    if (id) {
      this.service.findById(this.path, id).subscribe(
        usu => {
          this.usuario = usu;
          this.formulario.patchValue(this.usuario);

        },
      );
    }
  }

  private createForm(): FormGroup {
    return this.formBuilder.group({
      id: [null],
      nome: [null],
      email: this.formBuilder.control('', [Validators.required, Validators.pattern(this.emailPattern)]),
      carrinho:[null]
    });
  }
  salvar() {
    this.service.save(this.path, this.formulario.value).subscribe(
      async data => {
         console.log(data);
         await   this.location.back();

      },
      err => {
        console.log(err);
      }
    );
  }

 
}
