export class EmployeeProjectRequestDto
{
  employeeId: Number;
  currentPageNumber = 0;
  pageSize = 20;
  sortColumnName = 'projectId';
  sortDirection = 'desc';
  filterText: string;
}
