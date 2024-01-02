package lk.purna.HRManagementAPIV3.controller.request;

import lombok.Data;

@Data
public class CreateInsuranceRq {

    private int id;
    private String type;
    private String company;

}
