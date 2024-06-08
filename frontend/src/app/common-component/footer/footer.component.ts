import {Component} from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css', '../navigation/navigation.component.css']
})
export class FooterComponent {

    protected readonly window = window;
}
