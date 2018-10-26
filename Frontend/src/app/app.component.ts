import {Component, Renderer2} from '@angular/core';

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

  constructor(private renderer: Renderer2) {
    this.renderer.addClass(document.body, 'bg-light');
  }
}

interface Nav {
  link: string;
  name: string;
  exact: boolean;
}
