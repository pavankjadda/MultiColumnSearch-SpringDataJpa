import {AfterViewInit, Component, OnInit, ViewChild} from "@angular/core";
import {FormControl} from "@angular/forms";
import {MatPaginator, PageEvent} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {MatTableDataSource} from "@angular/material/table";
import {merge} from "rxjs";
import {catchError, map, startWith, switchMap} from "rxjs/operators";
import {EmployeeProject} from "src/app/api/model/employee-project";
import {EmployeeProjectRequestDto} from "src/app/api/model/employee-project-request-dto";
import {EmployeeProjectService} from "src/app/api/service/employee-project.service";
import {EMPLOYEE_API_URL, SystemConfig} from "src/app/constants/app.constants";
import {environment} from "src/environments/environment";


@Component({
  selector: "app-employee-project",
  templateUrl: "./employee-project.component.html",
  styleUrls: ["./employee-project.component.scss"]
})
export class EmployeeProjectComponent implements OnInit, AfterViewInit
{
  systemConfig: typeof SystemConfig = SystemConfig;
  initialLoadError: boolean = undefined;
  initialLoadErrorMessage = '';
  loading=true;
  loadingText = 'Loading...';
  spinnerName = 'app-employee-project';

  //Variables
  employeeId=1;
  employeeProjects: EmployeeProject[];
  pageSize=20;
  pageNumber=0;
  totalPages=1;
  totalElements=0;
  sortingOrderColumnName='registrationDate';
  filterText='';
  filterTextInput=new FormControl();

  //Mat-Table
  employeeProjectColumns: string[] = ['employeeId','lastName', 'firstName', 'projectId', 'projectName', 'projectBudget', 'projectLocation'];
  employeeProjectMatTableDataSource = new MatTableDataSource<EmployeeProject>();
  @ViewChild(MatPaginator, {static: false}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: false}) sort: MatSort;


  constructor(private employeeProjectService: EmployeeProjectService) {
  }

  ngOnInit(): void
  {
  }

  ngAfterViewInit(): void
  {
    this.employeeProjectMatTableDataSource.sort = this.sort;
    this.employeeProjectMatTableDataSource.paginator = this.paginator;

    // If the user changes the sort order, reset back to the first page.
    this.sort.sortChange.subscribe(() => this.paginator.pageIndex = 0);

    merge(this.sort.sortChange, this.paginator.page, this.filterTextInput.valueChanges)
      .pipe(
        startWith({}),
        switchMap(() =>
        {
          let employeeProjectRequestDto=this.buildEmployeeProjectsRequestDtoObject();
          this.loading=true;
          const url = environment.BASE_URL + EMPLOYEE_API_URL + '/find/projects/paginated/example_matcher';
          return this.employeeProjectService.getEmployeeProjects(url,employeeProjectRequestDto);
        }),
        map(data =>
        {
          // Flip flag to show that loading has finished.
          this.loading=false;
          this.totalElements = data.totalElements;
          return data;
        }),
        catchError(() =>
        {
          this.loading=false;
          return [];
        })
      ).subscribe(data =>
    {
      this.employeeProjects = data.content;
    });
  }

  private buildEmployeeProjectsRequestDtoObject()
  {
    let employeeProjectRequestDto=new EmployeeProjectRequestDto();
    employeeProjectRequestDto.employeeId=Number(this.employeeId);
    employeeProjectRequestDto.currentPageNumber=this.pageNumber;
    employeeProjectRequestDto.pageSize=this.pageSize;
    employeeProjectRequestDto.sortColumnName=this.sort.active==='lastName'?'lastName':this.sort.active;
    employeeProjectRequestDto.sortDirection=this.sort.direction;
    employeeProjectRequestDto.filterText=this.filterTextInput.value??null;
    return employeeProjectRequestDto;
  }

  changePage(pageEvent: PageEvent)
  {
    this.pageNumber=pageEvent.pageIndex;
    this.pageSize=pageEvent.pageSize;
  }
}
