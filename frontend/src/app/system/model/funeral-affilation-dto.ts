import {Provider} from "./provider";
import {AffilationType} from "./affilation-type";

export interface FuneralAffilationDto {
  provider: Provider,
  affilationType: AffilationType,
  unit: string,
  price: number,
  inStorage: number,
  expected: number,
  suppliesStopped: boolean,
  photoUrl: string,
  name: string,
  description: string
}
