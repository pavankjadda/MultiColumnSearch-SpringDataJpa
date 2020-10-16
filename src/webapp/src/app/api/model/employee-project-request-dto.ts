export class EmployeeProjectRequestDto
{
  employeeId: Number;
  currentPageNumber = 0;
  pageSize = 20;
  sortColumnName = 'lastName';
  sortDirection = 'desc';
  filterText: string;
}
