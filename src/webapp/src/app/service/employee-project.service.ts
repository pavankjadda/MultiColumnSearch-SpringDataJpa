import {HttpClient} from "@angular/common/http";
import { Injectable } from '@angular/core';
import {EmployeeProjectRequestDto} from "src/app/model/employee-project-request-dto";
import {PaginatedEmployeeProject} from "src/app/model/paginated-employee-project";

@Injectable({
  providedIn: 'root'
})
export class EmployeeProjectService {

  constructor(private httpClient: HttpClient)
  {
  }

  getEmployeeProjects(url: string, employeeProjectRequestDto: EmployeeProjectRequestDto)
  {
    return this.httpClient.post<PaginatedEmployeeProject>(url,employeeProjectRequestDto);
  }
}
