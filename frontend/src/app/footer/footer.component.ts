import { Component, OnInit } from '@angular/core';
import { Contact } from './contact';


@Component({
    selector: 'app-fotter',
    templateUrl: './footer.component.html',
    styleUrls: ['./footer.component.css']
})

export class FooterComponent implements OnInit {
    public contacts: Contact = {telephone: '+375-29-831-00-34', email: 'sasha.rudenya@yandex.ru'};
    ngOnInit(): void {
    }
}
