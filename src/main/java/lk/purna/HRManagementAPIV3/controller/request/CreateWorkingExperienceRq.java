package lk.purna.HRManagementAPIV3.controller.request;

import lombok.Data;

@Data
public class CreateWorkingExperienceRq {

    private int id;
    private int experienceYears;

    private String type;

}
