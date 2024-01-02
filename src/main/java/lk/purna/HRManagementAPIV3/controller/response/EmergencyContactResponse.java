package lk.purna.HRManagementAPIV3.controller.response;


import com.fasterxml.jackson.databind.node.LongNode;
import lombok.Data;

@Data

public class EmergencyContactResponse {

    private Long id;
    private String num1;
    private String num2;
}
