package lk.purna.HRManagementAPIV3.service.impl;

import lk.purna.HRManagementAPIV3.controller.model.Designation;
import lk.purna.HRManagementAPIV3.controller.repository.DesignationRepository;
import lk.purna.HRManagementAPIV3.controller.request.CreateDesignationRq;
import lk.purna.HRManagementAPIV3.controller.response.CreateDesignationResponse;
import lk.purna.HRManagementAPIV3.controller.response.CreateDesignationResponse2;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;
import lk.purna.HRManagementAPIV3.service.DesignationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DesignationServiceImpl implements DesignationService {

    private DesignationRepository designationRepository;


    @Override
    public CreateDesignationResponse add(CreateDesignationRq createDesignationRq) {

        System.out.println("added designation");


        Designation designation = new Designation();

        designation.setId(designation.getId());
        designation.setName(createDesignationRq.getName());

        designationRepository.save(designation);

        CreateDesignationResponse createDesignationResponse = new CreateDesignationResponse();

        createDesignationResponse.setId(designation.getId());
        createDesignationResponse.setName(designation.getName());

        return createDesignationResponse;
    }



    @Override
    public CreateDesignationResponse get(Long id){
        Optional<Designation> designationOptional = designationRepository.findById(id);
        CreateDesignationResponse createDesignationResponse = new CreateDesignationResponse();

        if (designationOptional.isPresent()){

            Designation designation = designationOptional.get();


            createDesignationResponse.setId(designation.getId());
            createDesignationResponse.setName(designation.getName());


        }
       return createDesignationResponse ;
    }

    @Override
    public List<CreateDesignationResponse2> getAll(CreateDesignationRq createDesignationRq) {

        List<Designation>designationList = designationRepository.findAll();

        return designationList.stream().map(designation -> CreateDesignationResponse2.builder().id(designation.getId()).name(designation.getName()).build()).toList();
    }

    @Override
    public MessageResponse delete(Long id) {
        MessageResponse messageResponse = new MessageResponse();

        designationRepository.deleteById(id);

        messageResponse.setMessage("successfully deleted "+id+" Designation");
        return  messageResponse;
    }

    @Override
    public CreateDesignationResponse update(Long id, CreateDesignationRq createDesignationRq) {

        Optional<Designation> designationOptional = designationRepository.findById(id);
        CreateDesignationResponse createDesignationResponse = new CreateDesignationResponse();

        if (designationOptional.isPresent()){

            Designation designation = designationOptional.get();

            designation.setId(designation.getId());
            designation.setName(createDesignationRq.getName());

            designationRepository.save(designation);

            createDesignationResponse.setId(designation.getId());
            createDesignationResponse.setName(designation.getName());

        }

        return createDesignationResponse;
    }
}

