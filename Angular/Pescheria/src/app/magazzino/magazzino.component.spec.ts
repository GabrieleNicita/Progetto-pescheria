import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MagazzinoComponent } from './magazzino.component';

describe('MagazzinoComponent', () => {
  let component: MagazzinoComponent;
  let fixture: ComponentFixture<MagazzinoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MagazzinoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MagazzinoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
