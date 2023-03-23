import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormInfoClientComponent } from './form-info-client.component';

describe('FormInfoClientComponent', () => {
  let component: FormInfoClientComponent;
  let fixture: ComponentFixture<FormInfoClientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormInfoClientComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormInfoClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
