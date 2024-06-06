import {Client} from "./client";

export interface OrderDto {
  client: Client,
  registrationDate: number[],
  appointmentDate: number[],
  executionDate: number[]
}
