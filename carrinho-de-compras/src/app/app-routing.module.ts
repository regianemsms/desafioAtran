import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { ItemComponent } from './item/item.component';
import { UsuarioComponent } from './usuario/usuario-form/usuario-form.component';
import { CarrinhoComponent } from './carrinho/carrinho.component';
import { BodyHomeComponent } from './body-home/body-home.component';
import { UsuarioListComponent } from './usuario/usuario-list/usuario-list.component';


export const routes: Routes = [
  {path: '', component: BodyHomeComponent},
  {path: 'usuarioForm', component: UsuarioComponent},
  {path: 'usuariolist', component: UsuarioListComponent},
  {path: 'item', component: ItemComponent},
  {path: 'carrinho', component: CarrinhoComponent}
  ];
  
  @NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
  })
  
  export class AppRoutingModule { }