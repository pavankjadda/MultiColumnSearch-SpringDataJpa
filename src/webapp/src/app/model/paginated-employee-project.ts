import {EmployeeProject} from "src/app/model/employee-project";


export interface Sort
{
  sorted: boolean;
  unsorted: boolean;
  empty: boolean;
}

export interface Pageable
{
  pageSize: number;
  pageNumber: number;
  offset: number;
  paged: boolean;
  sort: Sort;
}

export class PaginatedEmployeeProject
{
  content: EmployeeProject[];
  pageable: Pageable;
  totalPages: number;
  totalElements: number;
  number: number;
  size: number;
  numberOfElements: number;
  first: boolean;
  last: boolean;
  empty: boolean;
}
