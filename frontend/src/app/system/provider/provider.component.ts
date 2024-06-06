import {Component, OnInit} from '@angular/core';
import {ProviderService} from "../service/provider.service";
import {Provider} from "../model/provider";

@Component({
  selector: 'app-provider',
  templateUrl: './provider.component.html',
  styleUrls: ['./provider.component.css', '../../system/system.component.css']
})
export class ProviderComponent implements OnInit {

  constructor(private providerService: ProviderService) {
  }

  public providers: Provider[] = [];

  ngOnInit(): void {
    this.providerService.getAllProviders()
      .subscribe(ps =>
        ps.forEach(p => {
          console.log(p)
          this.providers.push(p)
        }));
  }



}
