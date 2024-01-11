package lk.purna.HRManagementAPIV3.controller.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.bytecode.enhance.spi.EnhancementInfo;

@Entity
@Data
@Table(name = "insurances")
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String company;

    @ManyToOne
    private Employee employee;
}
