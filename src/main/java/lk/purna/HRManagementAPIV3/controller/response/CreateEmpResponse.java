package lk.purna.HRManagementAPIV3.controller.response;

import lombok.Builder;
import lombok.Data;

@Data

public class CreateEmpResponse {

    private Long id;
    private String name;
    private String address;
}
