package lk.purna.HRManagementAPIV3.service.impl;

import lk.purna.HRManagementAPIV3.controller.model.WorkingExperience;
import lk.purna.HRManagementAPIV3.controller.repository.WorkingExperienceRepository;
import lk.purna.HRManagementAPIV3.controller.request.CreateWorkingExperienceRq;
import lk.purna.HRManagementAPIV3.controller.response.CreateWorkingExperienceResponse;
import lk.purna.HRManagementAPIV3.controller.response.CreateWorkingExperienceResponse2;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;
import lk.purna.HRManagementAPIV3.service.WorkingExperienceService;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkingExperienceImpl implements WorkingExperienceService {

    @Autowired
    private WorkingExperienceRepository workingExperienceRepository;


    @Override
    public CreateWorkingExperienceResponse add(CreateWorkingExperienceRq createWorkingExperienceRq) {

        System.out.println("add working Experience");

        WorkingExperience workingExperience = new WorkingExperience();


        workingExperience.setExperienceYear(createWorkingExperienceRq.getExperienceYears());
        workingExperience.setType(createWorkingExperienceRq.getType());

        workingExperienceRepository.save(workingExperience);

        CreateWorkingExperienceResponse createWorkingExperienceResponse = new CreateWorkingExperienceResponse();

        createWorkingExperienceResponse.setId(workingExperience.getId());
        createWorkingExperienceResponse.setType(createWorkingExperienceRq.getType());
        createWorkingExperienceResponse.setExperienceYears(createWorkingExperienceRq.getExperienceYears());

        return createWorkingExperienceResponse;

    }

    @Override
    public CreateWorkingExperienceResponse get(int id) {

        Optional<WorkingExperience> workingExperienceOptional = workingExperienceRepository.findById(id);


        if(workingExperienceOptional.isPresent()){

            WorkingExperience workingExperience = workingExperienceOptional.get();

            CreateWorkingExperienceResponse createWorkingExperienceResponse = new CreateWorkingExperienceResponse();

            createWorkingExperienceResponse.setId(workingExperience.getId());
            createWorkingExperienceResponse.setType(workingExperience.getType());
            createWorkingExperienceResponse.setExperienceYears(workingExperience.getExperienceYear());


            return createWorkingExperienceResponse;
        }
        return  null;


    }

    @Override
    public List<CreateWorkingExperienceResponse> getAll() {
        System.out.println("work experience version 01");


        List<WorkingExperience> workingExperiences = workingExperienceRepository.findAll();

        List<CreateWorkingExperienceResponse> createWorkingExperienceResponseList = new ArrayList<>();

        for(WorkingExperience workingExperience : workingExperiences){

            CreateWorkingExperienceResponse createWorkingExperienceResponse = new CreateWorkingExperienceResponse();

            createWorkingExperienceResponse.setExperienceYears(workingExperience.getId());
            createWorkingExperienceResponse.setType(workingExperience.getType());
            createWorkingExperienceResponse.setId(workingExperience.getId());

            createWorkingExperienceResponseList.add(createWorkingExperienceResponse);

        }

        return createWorkingExperienceResponseList;



    }





    @Override
    public MessageResponse delete(int id) {

        workingExperienceRepository.deleteById(id);

        MessageResponse messageResponse = new MessageResponse();

        messageResponse.setMessage("successfully deleted the "+id+" that experiences");

        return messageResponse;

    }

    @Override
    public CreateWorkingExperienceResponse update(int id, CreateWorkingExperienceRq createWorkingExperienceRq) {

        Optional<WorkingExperience> workingExperienceOptional = workingExperienceRepository.findById(id);

        if (workingExperienceOptional.isPresent()){

            WorkingExperience workingExperience = workingExperienceOptional.get();


            workingExperience.setId(workingExperience.getId());
            workingExperience.setExperienceYear(createWorkingExperienceRq.getExperienceYears());
            workingExperience.setType(createWorkingExperienceRq.getType());

            WorkingExperience updatedWorkingExperience =  workingExperienceRepository.save(workingExperience);

            CreateWorkingExperienceResponse createWorkingExperienceResponse = new CreateWorkingExperienceResponse();

            createWorkingExperienceResponse.setId(updatedWorkingExperience.getId());
            createWorkingExperienceResponse.setExperienceYears(updatedWorkingExperience.getExperienceYear());
            createWorkingExperienceResponse.setType(updatedWorkingExperience.getType());

            return createWorkingExperienceResponse;
        }

        return  null;




    }

    @Override
    public List<CreateWorkingExperienceResponse2> getAll2() {


        System.out.println("version 02");
        List<WorkingExperience> workingExperienceList = workingExperienceRepository.findAll();

        return workingExperienceList.stream().map(workingExperience -> CreateWorkingExperienceResponse2.builder().id(workingExperience.getId()).experienceYears(workingExperience.getExperienceYear()).type(workingExperience.getType()).build()).toList();
    }
}
