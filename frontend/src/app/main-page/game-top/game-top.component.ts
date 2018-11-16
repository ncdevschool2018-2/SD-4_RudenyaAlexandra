import { Component, OnInit } from '@angular/core';

interface Slider {
    url: string;
    text: string;
}

@Component({
    selector: 'app-game-top',
    templateUrl: './game-top.component.html',
    styleUrls: ['./game-top.component.css'],
})

export class GameComponent implements OnInit {
    ngOnInit(): void {
    }

    constructor() {
    }
}
