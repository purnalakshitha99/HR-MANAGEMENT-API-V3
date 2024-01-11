package lk.purna.HRManagementAPIV3.controller.request;

import lombok.Data;

@Data
public class CreateInsuranceRq {

    private Long id;
    private String type;
    private String company;

}
