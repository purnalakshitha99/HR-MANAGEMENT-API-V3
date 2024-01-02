package lk.purna.HRManagementAPIV3.controller.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name ="emergency")
@Data
public class Emergency {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String num1;
    private String num2;


    @ManyToOne
    private Employee employee;
}
