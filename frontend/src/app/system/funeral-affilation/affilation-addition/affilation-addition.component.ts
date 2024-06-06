import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {FuneralAffilationService} from "../../service/funeral-affilation.service";
import {AffilationTypeService} from "../../service/affilation-type.service";
import {ProviderService} from "../../service/provider.service";
import {FuneralAffilation} from "../../model/funeral-affilation";
import {Provider} from "../../model/provider";
import {AffilationType} from "../../model/affilation-type";
import {FuneralAffilationDto} from "../../model/funeral-affilation-dto";

@Component({
  selector: 'app-affilation-addition',
  templateUrl: './affilation-addition.component.html',
  styleUrls: ['./affilation-addition.component.css', '../../system.component.css']
})
export class AffilationAdditionComponent implements OnInit {
  constructor(private route: ActivatedRoute,
              private affilationService: FuneralAffilationService,
              private router: Router,
              private typeService: AffilationTypeService,
              private providerService: ProviderService) {
  }

  public providers: Provider[] = [];

  public types: AffilationType[] = [];

  public selectedProviderId!: number;

  public selectedTypeId!: number;

  public ngOnInit(): void {
    this.providerService.getAllProviders().subscribe(
      ps => ps.forEach(p => this.providers.push(p))
    )
    this.typeService.getAllAffilationTypes().subscribe(
      ts => ts.forEach(t => this.types.push(t))
    )
  }

  public submit(): void {
    if (this.form.valid) {
      let providerInAffilation: Provider = this.providers.filter(p => p.id == this.selectedProviderId).at(0) as Provider;
      let typeInAffilation: AffilationType = this.types.filter(t => t.id == this.selectedTypeId).at(0) as AffilationType;
      let affilation: FuneralAffilationDto = {
        provider: providerInAffilation,
        affilationType: typeInAffilation,
        unit: this.form.value.unit as string,
        price: this.form.value.price as number,
        inStorage: this.form.value.inStorage as number,
        expected: this.form.value.expected as number,
        suppliesStopped: this.form.value.suppliesStopped as boolean,
        photoUrl: this.form.value.photoUrl as string,
        name: this.form.value.name as string,
        description: this.form.value.description as string
      }

      this.affilationService.addAffilation(affilation as FuneralAffilation)
        .subscribe(_ => {
          alert('Принадлежность сохранена. Вы будете перенаправлены на страницу с принадлежностями.');
          this.router.navigate(['../../'], { relativeTo: this.route });
        });
    }
  }

  public form = new FormGroup({
    unit: new FormControl('', [
      Validators.required,
      Validators.minLength(1)
    ]),
    price: new FormControl(0, [
      Validators.required
    ]),
    inStorage: new FormControl(0, [
      Validators.required
    ]),
    expected: new FormControl(0, [
      Validators.required
    ]),
    suppliesStopped: new FormControl(false, [
      Validators.required
    ]),
    photoUrl: new FormControl('', []),
    name: new FormControl('', [
      Validators.required,
      Validators.minLength(3)
    ]),
    description: new FormControl('', [])
  })
}
