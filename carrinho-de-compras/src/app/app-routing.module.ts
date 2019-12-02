import { ItemListComponent } from './item/item-list/item-list.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UsuarioComponent } from './usuario/usuario-form/usuario-form.component';
import { CarrinhoComponent } from './carrinho/carrinho.component';
import { BodyHomeComponent } from './body-home/body-home.component';
import { UsuarioListComponent } from './usuario/usuario-list/usuario-list.component';
import { ItemComponent } from './item/item-form/item-form.component';

export const routes: Routes = [
  { path: '', component: BodyHomeComponent },
  { path: 'usuario', component: UsuarioComponent },
  { path: 'usuario/:id', component: UsuarioComponent },
  { path: 'usuariolist', component: UsuarioListComponent },
  { path: 'item', component: ItemComponent },
  { path: 'item/:id', component: ItemComponent },
  { path: 'itemlist', component: ItemListComponent },

  { path: 'carrinho', component: CarrinhoComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
