import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultationInfopersoComponent } from './consultation-infoperso.component';

describe('ConsultationInfopersoComponent', () => {
  let component: ConsultationInfopersoComponent;
  let fixture: ComponentFixture<ConsultationInfopersoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConsultationInfopersoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsultationInfopersoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
