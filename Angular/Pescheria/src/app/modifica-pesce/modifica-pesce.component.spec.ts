import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModificaPesceComponent } from './modifica-pesce.component';

describe('ModificaPesceComponent', () => {
  let component: ModificaPesceComponent;
  let fixture: ComponentFixture<ModificaPesceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModificaPesceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModificaPesceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
