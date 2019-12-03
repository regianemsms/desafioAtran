import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemComponent } from './item-form.component';

describe('ItemComponent', () => {
  let component: ItemComponent;
  let fixture: ComponentFixture<ItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  
  it('Deve testar Exibição de Protocolo', () => {
    component.protocolo.setValue('');
    expect(component.protocolo.validator).toBeFalsy();
    component.protocolo.setValue('123456789');
    expect(component.protocolo).not.toBeNull();
   });
});
