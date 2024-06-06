import {DatePipe} from "@angular/common";

export class Util {

  private static dateFormat: string = 'dd/MM/yyyy'

  public fixDate(date: number[]): string {
    let newDate: string = date[1] + '/' + date[2] + '/' + date[0];
    console.log(newDate)
    return new Date(newDate).toLocaleDateString();
  }

  public dateToArray(date: Date): number[] {
    let dateArray: number[] = [];
    dateArray.push(date.getFullYear(), date.getMonth(), date.getDate(), 0, 0);

    return dateArray;
  }

  public createDateArrayByDateData(date: number, month: number, year: number): number[] {
    let dateArray: number[] = [];
    dateArray.push(year, month, date, 0, 0);

    return dateArray;
  }
}
