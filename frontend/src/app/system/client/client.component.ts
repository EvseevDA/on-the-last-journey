import {Component, OnInit} from '@angular/core';
import {ClientService} from "../service/client.service";
import {Client} from "../model/client";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css', '../system.component.css']
})
export class ClientComponent implements OnInit {

  constructor(private clientService: ClientService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  public clients: Client[] = [];

  public selectedClientId: number = 0;

  public getSingletonClient(id: number | undefined): void {
    this.router.navigate([`${id}`], {relativeTo: this.route})
  }

  ngOnInit(): void {
    this.clientService.getAllClients()
      .subscribe(cs => {
        cs.forEach(c => this.clients.push(c));
        this.selectedClientId = this.clients[0].id;
      });
  }

}
