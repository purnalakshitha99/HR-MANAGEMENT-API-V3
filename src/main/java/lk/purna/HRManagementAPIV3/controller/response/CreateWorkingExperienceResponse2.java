package lk.purna.HRManagementAPIV3.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateWorkingExperienceResponse2 {

    private int id;
    private int experienceYears;
    private String type;
}
