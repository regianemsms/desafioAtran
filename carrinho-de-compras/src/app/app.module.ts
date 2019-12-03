import { UsuarioListComponent } from './usuario/usuario-list/usuario-list.component';
import { HomeComponent } from './home/home.component';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {AccordionModule} from 'primeng/accordion';
import {CardModule} from 'primeng/card';
import {ButtonModule} from 'primeng/button';
import {StepsModule} from 'primeng/steps';
import { CarrinhoComponent } from './carrinho/carrinho.component';
import { BodyHomeComponent } from './body-home/body-home.component';
import { UsuarioComponent } from './usuario/usuario-form/usuario-form.component';
import {ToolbarModule} from 'primeng/toolbar';
import { FormBuilder } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CrudService } from './services/crud.service';
import { ItemListComponent } from './item/item-list/item-list.component';
import { ItemComponent } from './item/item-form/item-form.component';
import {TabMenuModule} from 'primeng/tabmenu';
import {TableModule} from 'primeng/table';
import {MessageService} from 'primeng/api';
import {DropdownModule} from 'primeng/dropdown';
import {MultiSelectModule} from 'primeng/multiselect';
import {TooltipModule} from 'primeng/tooltip';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UsuarioComponent,
    ItemComponent,
    CarrinhoComponent,
    BodyHomeComponent,
    UsuarioListComponent,
    ItemListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AccordionModule,
    CardModule,
    ReactiveFormsModule,
    ButtonModule,
    FormsModule,
    StepsModule,
    ToolbarModule,
    HttpClientModule,
    TabMenuModule,
    TableModule,
    DropdownModule,
    MultiSelectModule,
    TooltipModule
  ],
  providers: [FormBuilder,
    HttpClient,
    CrudService,
    MessageService],
  bootstrap: [AppComponent],
})
export class AppModule { }
