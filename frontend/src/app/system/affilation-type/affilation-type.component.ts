import {Component, OnInit} from '@angular/core';
import {AffilationTypeService} from "../service/affilation-type.service";
import {ActivatedRoute, Router} from "@angular/router";
import {AffilationType} from "../model/affilation-type";

@Component({
  selector: 'app-affilation-type',
  templateUrl: './affilation-type.component.html',
  styleUrls: ['./affilation-type.component.css', '../../system/system.component.css']
})
export class AffilationTypeComponent implements OnInit {

  constructor(private affilationTypeService: AffilationTypeService,) {
  }

  public affilationTypes: AffilationType[] = [];

  ngOnInit(): void {
    this.affilationTypeService.getAllAffilationTypes()
      .subscribe(ats =>
        ats.forEach(at => this.affilationTypes.push(at)));
  }

}
