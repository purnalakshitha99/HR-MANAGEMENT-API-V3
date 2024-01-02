package lk.purna.HRManagementAPIV3.controller.request;

import lombok.Data;

@Data
public class EducationQualificationRq {

    private Long id;
    private String degree;
    private String institute;
    private String startDate;
    private String endDate;
}
