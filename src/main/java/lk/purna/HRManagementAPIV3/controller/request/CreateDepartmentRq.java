package lk.purna.HRManagementAPIV3.controller.request;

import lombok.Data;

@Data
public class CreateDepartmentRq {

    private int depId;
    private String name;
    private String location;
}
