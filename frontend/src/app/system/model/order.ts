import {Client} from "./client";

export interface Order {
  id: number,
  client: Client,
  registrationDate: number[],
  appointmentDate: number[],
  executionDate: number[]
}
