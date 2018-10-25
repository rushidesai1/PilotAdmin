import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {SearchPilotsComponent} from './search-pilots.component';

describe('SearchPilotsComponent', () => {
  let component: SearchPilotsComponent;
  let fixture: ComponentFixture<SearchPilotsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [SearchPilotsComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchPilotsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
