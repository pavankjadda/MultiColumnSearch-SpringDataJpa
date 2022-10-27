package com.pj.multicolumnsearch.dto;

import lombok.Data;

/**
 * @author Pavan Jadda
 */
@Data
public class EmployeeRequestDTO {
    private Long employeeId;
    private Integer currentPageNumber = 0;
    private Integer pageSize = 20;
    private String sortColumnName = "lastName";
    private String sortDirection = "desc";
    private String filterText;

    public String getFilterText() {
        return filterText.isBlank() ? null : filterText;
    }
}
