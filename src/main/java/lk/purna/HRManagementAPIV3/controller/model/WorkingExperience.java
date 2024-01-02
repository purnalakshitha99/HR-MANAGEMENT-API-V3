package lk.purna.HRManagementAPIV3.controller.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "workingExperiences")

public class WorkingExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int experienceYear;
    private String type;

    @ManyToOne
    private Employee employee;
}
