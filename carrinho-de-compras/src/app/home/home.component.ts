import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MenuItem } from 'primeng/components/common/menuitem';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  
  itensMenu: MenuItem[];
  
  constructor(
    private router: Router,
  ) { }

  ngOnInit() {
      this.itensMenu = [
          {label: 'Usuário', routerLink: 'usuariolist'},
          {label: 'Carrinho', routerLink: 'carrinho'},
          {label: 'Itens', routerLink: 'itemlist'},
      ];
  }
}
