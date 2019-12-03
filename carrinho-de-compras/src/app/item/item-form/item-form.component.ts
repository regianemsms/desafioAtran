import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Item } from 'src/app/model/item.model';
import { Location } from '@angular/common';
import { CrudService } from 'src/app/services/crud.service';
import { MessageService } from 'primeng/api';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-item',
  templateUrl: './item-form.component.html',
  styleUrls: ['./item-form.component.css']
})
export class ItemComponent implements OnInit {
  formulario: FormGroup;
  path = 'item';
  item: Item;

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
      this.service.findById(this.path, id).subscribe(data => {
        this.item = data;
        this.formulario.patchValue(this.item);
      });
    }
  }

  private createForm(): FormGroup {
    return this.formBuilder.group({
      id: [null],
      nome: [null, [Validators.required]],
      valor: [null, [Validators.required]]
    });
  }

  async salvar() {
    if (this.formulario.valid) {
      const valor = this.formulario.get('valor').value;
      if (valor <= 0) {
        alert('Valor não pode ser igual ou inferior a Zero');
      } else {
        this.service.save(this.path, this.formulario.value).subscribe(
          data => {
            this.location.back();
          },
          err => {
            console.log(err);
          }
        );
      }
    } else {
      this.validarCampos();
    }
  }
  private validarCampos() {
    if (
      this.formulario.get('nome').invalid ||
      this.formulario.get('valor').invalid
    ) {
      alert('Todos os campos são de preenchimento obrigatório');
    }
  }
}
