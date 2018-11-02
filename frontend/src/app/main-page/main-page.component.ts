import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-main-page',
    templateUrl: './main-page.component.html'
})

export class MainPageComponent implements OnInit {
    isCollapsed = false;
    constructor() {}
    ngOnInit() {
  }
}
