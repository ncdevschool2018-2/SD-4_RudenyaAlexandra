import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-component-top',
    templateUrl: './main-component-top.component.html',
    styleUrls: ['./main-component-top.component.css']
})

export class MainTopComponent implements OnInit {
    isCollapsed = false;
    constructor() {}
    ngOnInit() {
  }
}
