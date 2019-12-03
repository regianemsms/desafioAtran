import { async } from '@angular/core/testing';
import { Carrinho } from './../model/carrinho.model';
import { Usuario } from './../model/usuario.model';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { CrudService } from '../services/crud.service';
import { MessageService } from 'primeng/api';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Item } from '../model/item.model';
import { Produto } from '../model/produto.model';

@Component({
  selector: 'app-carrinho',
  templateUrl: './carrinho.component.html',
  styleUrls: ['./carrinho.component.css']
})
export class CarrinhoComponent implements OnInit {
  formulario: FormGroup;
  pathUsuario = 'usuario';
  pathItem = 'item';
  usuario: Usuario = new Usuario();
  usuarios: Usuario[];
  itens: Item[];
  quantidade: number;
  cols: any[];
  mapItens: Map<number, Item> = new Map();
  produto: Produto = new Produto();
  produtos: Produto[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private service: CrudService,
    private msgService: MessageService,
    private location: Location,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.formulario = this.createForm();
    this.formulario.valueChanges.subscribe(
     data => console.log(data)
    );
    this.listarItens();
    this.listarUsuarios();
    this.loadTable();
  }
   existsUser() {
    if (this.formulario.get('usuario').value) {
     this.popularProdutos();
      return this.formulario.get('usuario').get('id').value ? true : false;
    }
    return false;
  }

  private popularProdutos() {
    this.produtos = [];
    if (this.formulario.get('usuario').get('carrinho').value && this.formulario.get('usuario').get('carrinho').get('produtos')) {
      this.produtos =  this.formulario.get('usuario').get('carrinho').get('produtos').value;
      console.log('produtos', this.produtos);
    }
  }

  private createForm(): FormGroup {
    return this.formBuilder.group({
        usuario :  this.formBuilder.group({
        id: [null],
        nome: [null],
        email: [null],
        carrinho: this.formBuilder.group({
          produtos: [null]
        }),
       }),
       quantidade: [null],
       item:  this.formBuilder.group({
          id: [null],
          nome: [null],
          valor: [null]
      }),
    });
  }
  listarUsuarios() {
    this.service.list(this.pathUsuario).subscribe(
      data => this.usuarios = data,
      () => alert('Erro ao buscar usuarios!')
    );
  }
  listarItens() {
    this.service.list(this.pathItem).subscribe(
      data => {
      this.itens = data;
    },
      () => alert('Erro ao buscar itens!')
    );
  }
  addItem() {
    this.usuario =  this.formulario.get('usuario').value;
    this.usuario.carrinho = new Carrinho();
    this.usuario.carrinho.produtos = [];

    this.produto.item = this.formulario.get('item').value;
    this.produto.quantidade = this.formulario.get('quantidade').value;
    this.usuario.carrinho.produtos = [this.produto];
    this.salvar();
  }

  async deleteItem(produto: Produto) {
    if (confirm('Deseja realmente excluir este item?')) {
      this.usuario =  this.formulario.get('usuario').value;
      this.service
        .deleteProd(this.pathUsuario, produto.item.id, this.usuario.id)
        .subscribe(async () => (
          this.loadTela(this.usuario.id)
          ,
          () => {
            return alert('Erro ao tentar excluir!');
          }
        ));
      }
    }
  async salvar() {
    this.service.save(this.pathUsuario, this.usuario).subscribe(
      data =>
        this.loadTela(this.usuario.id)
      ,
      err => {
        console.log(err);
      }
    );
  }
  loadTela(idUsuario : string) {
    this.service.findById(this.pathUsuario, idUsuario).subscribe(
      data => [this.usuario = data,
        this.formulario.get('usuario').patchValue(this.usuario)
      ],
      () => alert('Erro ao buscar usuarios!')
    );
  }
  loadTable() {
    this.cols = [
      { field: 'quantidade', header: 'Quantidade' },
      { field: 'item.nome', header: 'Nome' },
      { field: 'item.valor', header: 'Valor' }
  ];
  }
}