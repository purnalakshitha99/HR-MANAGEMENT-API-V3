package lk.purna.HRManagementAPIV3.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CreateEmpResponse2 {

    private Long id;
    private String name;
    private String address;
}
