import { UsuarioListComponent } from './usuario/usuario-list/usuario-list.component';
import { HomeComponent } from './home/home.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {AccordionModule} from 'primeng/accordion';
import {CardModule} from 'primeng/card';
import {ButtonModule} from 'primeng/button';
import {StepsModule} from 'primeng/steps';
import { ItemComponent } from './item/item.component';
import { CarrinhoComponent } from './carrinho/carrinho.component';
import { BodyHomeComponent } from './body-home/body-home.component';
import { UsuarioComponent } from './usuario/usuario-form/usuario-form.component';
import {ToolbarModule} from 'primeng/toolbar';
import { FormBuilder } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CrudService } from './services/crud.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UsuarioComponent,
    ItemComponent,
    CarrinhoComponent,
    BodyHomeComponent,
    UsuarioListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AccordionModule,
    CardModule,
    ButtonModule,
    StepsModule,
    ToolbarModule,
    HttpClientModule

  ],
  providers: [FormBuilder,
    HttpClient,
    CrudService],
  bootstrap: [AppComponent],
})
export class AppModule { }
