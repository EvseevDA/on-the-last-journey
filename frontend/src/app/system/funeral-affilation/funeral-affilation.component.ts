import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FuneralAffilationService} from "../service/funeral-affilation.service";
import {FuneralAffilation} from "../model/funeral-affilation";

@Component({
  selector: 'app-funeral-affilation',
  templateUrl: './funeral-affilation.component.html',
  styleUrls: ['./funeral-affilation.component.css', '../../system/system.component.css']
})
export class FuneralAffilationComponent implements OnInit {
  constructor(private funeralAffilationService: FuneralAffilationService,
              private router: Router,
              private route: ActivatedRoute) {

  }

  public affilations: FuneralAffilation[] = [];

  public selectedAffilationId: number = 0;

  public getSingletonAffilation(id: number | undefined): void {
    this.router.navigate([`${id}`], { relativeTo: this.route })
  }

  public ngOnInit(): void {
    this.funeralAffilationService.getAllAffilations()
      .subscribe(as => {
        as.forEach(a => {
          this.affilations.push(a)
        });
        this.selectedAffilationId = this.affilations[0].id;
      });
  }
}
