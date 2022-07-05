import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InserimentoPesceComponent } from './inserimento-pesce.component';

describe('InserimentoPesceComponent', () => {
  let component: InserimentoPesceComponent;
  let fixture: ComponentFixture<InserimentoPesceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InserimentoPesceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InserimentoPesceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
