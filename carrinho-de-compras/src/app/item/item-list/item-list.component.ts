import { Component, OnInit } from '@angular/core';
import { Item } from 'src/app/model/item.model';
import { FormGroup, FormBuilder } from '@angular/forms';
import { CrudService } from 'src/app/services/crud.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {

  itens: Item[];
  cols: any[];
  searchForm: FormGroup;
  path = 'item';

  constructor(
    private formBuilder: FormBuilder,
    private service: CrudService
  ) { }

  ngOnInit() {
    this.loadTable();
    this.list();
  }


  loadTable() {
    this.cols = [
      { field: 'nome', header: 'Nome' },
      { field: 'valor', header: 'Valor' },
  ];
  }

  list() {
    this.service.list(this.path).subscribe( data =>
      this.itens = data,
      () => alert('Erro ao buscar usuarios!'));
  }

  update() {

  }

   delete(item: Item) {
    if (confirm('Deseja realmente excluir este item?')) {
      this.service
        .delete(this.path, item.id)
        .subscribe(
          async () => ( await this.list,
          () => alert('Erro ao tentar excluir!')
        ));
      }
  }}
