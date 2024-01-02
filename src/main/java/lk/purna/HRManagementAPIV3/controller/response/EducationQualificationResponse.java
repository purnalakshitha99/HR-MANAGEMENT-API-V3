package lk.purna.HRManagementAPIV3.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
public class EducationQualificationResponse {

    private Long id;
    private String degree;
    private String institute;
    private String startDate;
    private String endDate;
}
