import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultationAdmininfopersoComponent } from './consultation-admininfoperso.component';

describe('ConsultationAdmininfopersoComponent', () => {
  let component: ConsultationAdmininfopersoComponent;
  let fixture: ComponentFixture<ConsultationAdmininfopersoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConsultationAdmininfopersoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsultationAdmininfopersoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
