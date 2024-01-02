package lk.purna.HRManagementAPIV3.controller.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String address;

    @OneToMany(mappedBy = "employee")
    private List<Designation> designationList;

    @OneToMany(mappedBy = "employee")
    private List<Emergency> emergencyList;

    @OneToMany(mappedBy = "employee")
    private List<Insurance> insurancesList;

    @OneToMany(mappedBy = "employee")
    private List<Dependencies> dependenciesList;

    @OneToMany(mappedBy = "employee")
    private List<WorkingExperience> workingExperienceList;

    @JoinTable(name ="employee_department",joinColumns = @JoinColumn(name = "employee_id"),inverseJoinColumns = @JoinColumn(name = "department_id"))
    @ManyToMany
    private List<Department> departmentList;

    @OneToMany(mappedBy = "employee")
    private List<Education> educationList;
}
