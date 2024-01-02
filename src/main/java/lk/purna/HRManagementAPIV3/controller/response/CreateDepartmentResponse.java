package lk.purna.HRManagementAPIV3.controller.response;

import lombok.Builder;
import lombok.Data;

@Data

public class CreateDepartmentResponse {

    private int depId;
    private String name;
    private String location;
}
