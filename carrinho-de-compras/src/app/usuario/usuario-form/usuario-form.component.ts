import { Usuario } from './../../model/usuario.model';
import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup, FormControl } from '@angular/forms';
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
  path = 'usuario';
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

  updateVerify() {
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
      id: [],
      nome: [null, [Validators.required]],
      email: [null, [Validators.pattern(this.emailPattern)]],
      carrinho: [],
    });
  }
  private validarCampos(){
    if(this.formulario.get('nome').invalid && this.formulario.get('email').invalid) {
      alert('Todos os campos são de preenchimento obrigatório');
    } else {
      alert('E-mail inválido');
    }
  }
  async salvar() {
    if (this.formulario.valid) {
      this.service.save(this.path, this.formulario.value).subscribe(
        data => {
          this.location.back();
        },
        err => {
          console.log(err);
        }
        );
      } else {
        this.validarCampos();
      }
  }
}
