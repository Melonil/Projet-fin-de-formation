import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableOperationClientComponent } from './table-operation-client.component';

describe('TableOperationClientComponent', () => {
  let component: TableOperationClientComponent;
  let fixture: ComponentFixture<TableOperationClientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TableOperationClientComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TableOperationClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
