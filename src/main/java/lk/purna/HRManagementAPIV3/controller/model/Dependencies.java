package lk.purna.HRManagementAPIV3.controller.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "dependencies")
public class Dependencies {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer total;

    @ManyToOne
    private Employee employee;
}
