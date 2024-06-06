import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params, Router} from "@angular/router";
import {FuneralAffilationService} from "../../service/funeral-affilation.service";
import {AffilationTypeService} from "../../service/affilation-type.service";
import {ProviderService} from "../../service/provider.service";
import {FuneralAffilation} from "../../model/funeral-affilation";
import {AffilationType} from "../../model/affilation-type";
import {Provider} from "../../model/provider";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-singleton-affilation',
  templateUrl: './singleton-affilation.component.html',
  styleUrls: ['./singleton-affilation.component.css', '../../system.component.css']
})
export class SingletonAffilationComponent implements OnInit {

  constructor(private route: ActivatedRoute,
              private affilationService: FuneralAffilationService,
              private router: Router,
              private typeService: AffilationTypeService,
              private providerService: ProviderService) {
  }

  public instance!: FuneralAffilation;

  public types: AffilationType[] = [];

  public providers: Provider[] = [];

  public selectedTypeId!: number;

  public selectedProviderId!: number;

  public editingMode: boolean = false;

  public ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      this.affilationService.getAffilationById(params['id']).subscribe(a => {
        this.instance = a;
        this.selectedProviderId = this.instance.provider.id;
        this.selectedTypeId = this.instance.affilationType.id;
        this.providerService.getAllProviders().subscribe(
          cs => cs.forEach(c => {
            this.providers.push(c)
          })
        );
        this.typeService.getAllAffilationTypes().subscribe(
          ts => ts.forEach(t => {
            this.types.push(t)
          })
        );
        console.log(1)
      });
    });
  }

  public edit(): void {
    this.form.get('unit')?.setValue(this.instance.unit)
    this.form.get('price')?.setValue(this.instance.price)
    this.form.get('inStorage')?.setValue(this.instance.inStorage)
    this.form.get('expected')?.setValue(this.instance.expected)
    this.form.get('suppliesStopped')?.setValue(this.instance.suppliesStopped)
    this.form.get('photoUrl')?.setValue(this.instance.photoUrl)
    this.form.get('name')?.setValue(this.instance.name)
    this.form.get('description')?.setValue(this.instance.description)
    this.editingMode = true;
  }

  public cancelEditing(): void {
    this.editingMode = false;
  }

  public deleteById(id: number): void {
    let deletionConfirmed: boolean = confirm(`Вы действительно хотите удалить принадлежность с id ${id}?`);
    if (deletionConfirmed) {
      this.affilationService.deleteAffilation(id).subscribe(_ => {
        alert('Принадлежность удалена, вы будете перенаправлены на страницу с принадлежностями');
        this.router.navigate(['../'], {relativeTo: this.route});
      });
    }
  }

  public submit(): void {
    if (this.form.valid) {
      let providerInAffilation: Provider = this.providers.filter(p => p.id == this.selectedProviderId).at(0) as Provider;
      let typeInAffilation: AffilationType = this.types.filter(t => t.id == this.selectedTypeId).at(0) as AffilationType;

      let affilation: FuneralAffilation = {
        id: this.instance.id,
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

      this.affilationService.updateAffilation(affilation as FuneralAffilation)
        .subscribe(o => {
          alert('Принадлженость сохранена. Вы будете перенаправлены на страницу с принадлежностями.');
          this.router.navigate(['../'], {relativeTo: this.route});
        });
    }
  }

  public form = new FormGroup({
    unit: new FormControl(this.instance?.unit, [
      Validators.required,
      Validators.minLength(1)
    ]),
    price: new FormControl(this.instance?.price, [
      Validators.required
    ]),
    inStorage: new FormControl(this.instance?.inStorage, [
      Validators.required
    ]),
    expected: new FormControl(this.instance?.expected, [
      Validators.required
    ]),
    suppliesStopped: new FormControl(this.instance?.suppliesStopped, [
      Validators.required
    ]),
    photoUrl: new FormControl(this.instance?.photoUrl, []),
    name: new FormControl(this.instance?.name, [
      Validators.required,
      Validators.minLength(3)
    ]),
    description: new FormControl(this.instance?.description, [])
  })
}
