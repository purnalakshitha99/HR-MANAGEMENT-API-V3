package lk.purna.HRManagementAPIV3.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateInsuranceResponse2 {

    private int id;
    private String type;
    private String company;
}
