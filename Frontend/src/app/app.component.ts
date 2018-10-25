import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Frontend';

  nav: Nav[] = [
    {
      link: '/',
      name: 'Pilot',
      exact: true
    },
    {
      link: 'labels',
      name: 'Labels',
      exact: false
    }
  ];
}

interface Nav {
  link: string;
  name: string;
  exact: boolean;
}
