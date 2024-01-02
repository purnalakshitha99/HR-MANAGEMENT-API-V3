package lk.purna.HRManagementAPIV3.controller.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class EmergencyContactResponse2 {

    private Long id;
    private String num1;
    private String num2;
}
