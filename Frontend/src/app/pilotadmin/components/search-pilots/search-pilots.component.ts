import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-search-pilots',
  templateUrl: './search-pilots.component.html',
  styleUrls: ['./search-pilots.component.scss']
})
export class SearchPilotsComponent implements OnInit {

  searchForm: FormGroup = new FormGroup({
    search: new FormControl('')
  });

  constructor() {
  }

  ngOnInit() {
  }

  onSubmit() {
    // TODO: Use EventEmitter with form value
    console.log(this.searchForm.value);
  }

}
