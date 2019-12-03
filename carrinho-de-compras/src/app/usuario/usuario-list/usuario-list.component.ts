import { Usuario } from './../../model/usuario.model';
import { Component, OnInit } from '@angular/core';
import { CrudService } from 'src/app/services/crud.service';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-usuario-list',
  templateUrl: './usuario-list.component.html',
  styleUrls: ['./usuario-list.component.css']
})
export class UsuarioListComponent implements OnInit {

  usuarios: Usuario[];
  cols: any[];
  searchForm: FormGroup;
  path = 'usuario';

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
      { field: 'email', header: 'E-mail' },
  ];
  }

  list() {
    this.service.list(this.path).subscribe( data =>
      this.usuarios = data,
      () => alert('Erro ao buscar usuarios!'));
  }

  async delete(usuario: Usuario) {
    if (confirm('Deseja realmente excluir este item?')) {
      this.service
        .delete(this.path, usuario.id)
        .subscribe(
          () => ( this.list(),
          () => alert('Erro ao tentar excluir!')
        ));
    }
  }
}
