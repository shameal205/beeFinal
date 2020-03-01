import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BeeTableComponent } from './bee-table.component';

describe('BeeTableComponent', () => {
  let component: BeeTableComponent;
  let fixture: ComponentFixture<BeeTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BeeTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BeeTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
