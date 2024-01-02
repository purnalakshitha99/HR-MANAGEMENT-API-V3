package lk.purna.HRManagementAPIV3.controller.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "educations")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String degree;
    private String institute;
    private String startDate;
    private String endDate;

    @ManyToOne
    private Employee employee;
}
