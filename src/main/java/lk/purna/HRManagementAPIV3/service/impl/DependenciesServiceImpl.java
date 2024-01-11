package lk.purna.HRManagementAPIV3.service.impl;

import lk.purna.HRManagementAPIV3.controller.model.Dependencies;
import lk.purna.HRManagementAPIV3.controller.model.Employee;
import lk.purna.HRManagementAPIV3.controller.repository.DependenciesRepository;
import lk.purna.HRManagementAPIV3.controller.repository.EmployeeRepository;
import lk.purna.HRManagementAPIV3.controller.request.DependenciesRq;
import lk.purna.HRManagementAPIV3.controller.response.DependenciesResponse;
import lk.purna.HRManagementAPIV3.controller.response.DependenciesResponse2;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;
import lk.purna.HRManagementAPIV3.exception.DependenciesNotFoundException;
import lk.purna.HRManagementAPIV3.exception.EmployeeNotFoundException;
import lk.purna.HRManagementAPIV3.service.DependenciesService;
import lombok.AllArgsConstructor;
import org.aspectj.bridge.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DependenciesServiceImpl implements DependenciesService {

    private DependenciesRepository dependenciesRepository;
    private EmployeeRepository employeeRepository;


    @Override
    public DependenciesResponse add(DependenciesRq dependenciesRq) {

        Dependencies dependencies = new Dependencies();

        dependencies.setTotal(dependenciesRq.getTotal());

       dependenciesRepository.save(dependencies);

       DependenciesResponse dependenciesResponse = new DependenciesResponse();

       dependenciesResponse.setId(dependencies.getId());
       dependenciesResponse.setTotal(dependencies.getTotal());

       return dependenciesResponse;


    }

    @Override
    public DependenciesResponse get(Long id) {

        Optional<Dependencies> dependenciesOptional = dependenciesRepository.findById(id);

        if(dependenciesOptional.isPresent()){

            Dependencies dependencies = dependenciesOptional.get();

            dependencies.setId(dependencies.getId());
            dependencies.setTotal(dependencies.getTotal());

            DependenciesResponse dependenciesResponse = new DependenciesResponse();

            dependenciesResponse.setId(dependencies.getId());
            dependenciesResponse.setTotal(dependencies.getTotal());

            return dependenciesResponse;
        }

        return null;
    }

    @Override
    public List<DependenciesResponse> getAll() {

        List<Dependencies> dependenciesList = dependenciesRepository.findAll();
        List<DependenciesResponse> dependenciesResponseList = new ArrayList<>();

        for (Dependencies dependencies : dependenciesList ){

            

            DependenciesResponse dependenciesResponse = new DependenciesResponse();

            dependenciesResponse.setId(dependencies.getId());
            dependenciesResponse.setTotal(dependencies.getTotal());

            dependenciesResponseList.add(dependenciesResponse);

        }

       return dependenciesResponseList;




        }

    public List<DependenciesResponse2> getAll2(){
        System.out.println("version 2");

        List<Dependencies> dependenciesList = dependenciesRepository.findAll();

        return dependenciesList.stream().map(dependencies -> DependenciesResponse2.builder().id(dependencies.getId()).total(dependencies.getTotal()).build()).toList();
    }

    @Override
    public MessageResponse delete(Long id) {

        dependenciesRepository.deleteById(id);

        MessageResponse messageResponse = new MessageResponse();

        messageResponse.setMessage("delete by "+id+" dependencies");

        return messageResponse;
    }

    @Override
    public DependenciesResponse update(Long id, DependenciesRq dependenciesRq) {


        Optional<Dependencies> dependenciesOptional = dependenciesRepository.findById(id);

        if (dependenciesOptional.isPresent()){

            Dependencies dependencies = dependenciesOptional.get();

            dependencies.setTotal(dependenciesRq.getTotal());

            dependenciesRepository.save(dependencies);

            DependenciesResponse dependenciesResponse = new DependenciesResponse();

            dependenciesResponse.setId(dependencies.getId());
            dependenciesResponse.setTotal(dependencies.getTotal());

            return dependenciesResponse;

        }

        return null;

    }

    @Override
    public DependenciesResponse addDependencies(Long employeeId,DependenciesRq dependenciesRq) throws  EmployeeNotFoundException {

        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);

        DependenciesResponse dependenciesResponse = new DependenciesResponse();

        if (!employeeOptional.isPresent()){


            throw new EmployeeNotFoundException("Employee Not Found in the System :"+employeeId);

        }
        Employee employee = employeeOptional.get();

        Dependencies dependencies = new Dependencies();

        dependencies.setTotal(dependenciesRq.getTotal());
        dependencies.setRelationship(dependenciesRq.getRelationship());

        dependencies.setEmployee(employee);

        dependenciesRepository.save(dependencies);

        dependenciesResponse.setTotal(dependencies.getTotal());
        dependenciesResponse.setRelationship(dependencies.getRelationship());
        dependenciesResponse.setId(dependencies.getId());


        return dependenciesResponse;
    }

   public List<DependenciesResponse2> getDependencies(Long employeeId)throws EmployeeNotFoundException{

        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);

        List<DependenciesResponse2> dependenciesResponse2List = new ArrayList<>();

        if (!employeeOptional.isPresent()){
            System.out.println("That Employee not found in the system "+employeeId);
           throw new EmployeeNotFoundException("That Employee not found in the system "+employeeId);

        }

       Employee employee = employeeOptional.get();
       List<Dependencies>dependenciesList = employee.getDependenciesList();

       if (dependenciesList != null){

           dependenciesResponse2List =  dependenciesList.stream()
                   .map(dependencies -> DependenciesResponse2.builder()
                           .id(dependencies.getId())
                           .relationship(dependencies.getRelationship())
                           .total(dependencies.getTotal())
                           .build()).toList();
       }

        return dependenciesResponse2List;

   }

    @Override
    public DependenciesResponse getSpecificDependencies(Long employeeId, Long dependenciesId) throws EmployeeNotFoundException, DependenciesNotFoundException {

        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        DependenciesResponse dependenciesResponse = new DependenciesResponse();



        if (!employeeOptional.isPresent()){
            System.out.println("Employee Not Found in this System "+employeeId);
            throw new EmployeeNotFoundException("Employee Not Found in this System "+employeeId);

        }

        Employee employee = employeeOptional.get();
        List<Dependencies> dependenciesList = employee.getDependenciesList();

        Dependencies dependenciesToGetSpecific = dependenciesList.stream().filter(dependencies -> dependencies.getId().equals(dependenciesId)).findFirst().orElse(null);

        if (dependenciesToGetSpecific == null){

            System.out.println("Dependencies not found in that system "+dependenciesId);
            throw new DependenciesNotFoundException("Dependencies not found in that system "+dependenciesId);


        }
        dependenciesResponse.setId(dependenciesId);
        dependenciesResponse.setTotal(dependenciesToGetSpecific.getTotal());
        dependenciesResponse.setRelationship(dependenciesToGetSpecific.getRelationship());

        return dependenciesResponse;
    }


    public DependenciesResponse updateSpecificDependencies(Long employeeId,Long dependenciesId,DependenciesRq dependenciesRq){

        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        DependenciesResponse dependenciesResponse = new DependenciesResponse();

        if (employeeOptional.isPresent()){

            Employee employee = employeeOptional.get();
            List<Dependencies> dependenciesList = employee.getDependenciesList();

            Dependencies dependenciesListToUpdate = dependenciesList.stream().filter(dependencies -> dependencies.getId().equals(dependenciesId)).findFirst().orElse(null);


            if (dependenciesListToUpdate != null){

                dependenciesListToUpdate.setId(dependenciesId);
                dependenciesListToUpdate.setTotal(dependenciesRq.getTotal());
                dependenciesListToUpdate.setRelationship(dependenciesRq.getRelationship());

                dependenciesListToUpdate.setEmployee(employee);

                dependenciesRepository.save(dependenciesListToUpdate);

             dependenciesResponse.setRelationship(dependenciesListToUpdate.getRelationship());
             dependenciesResponse.setId(dependenciesId);
             dependenciesResponse.setTotal(dependenciesListToUpdate.getTotal());


            }
        }
        return dependenciesResponse;
    }
}
