import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultationCompteComponent } from './consultation-compte.component';

describe('ConsultationCompteComponent', () => {
  let component: ConsultationCompteComponent;
  let fixture: ComponentFixture<ConsultationCompteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConsultationCompteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsultationCompteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
