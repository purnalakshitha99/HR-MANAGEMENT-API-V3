package lk.purna.HRManagementAPIV3.service.impl;

import lk.purna.HRManagementAPIV3.controller.model.Education;
import lk.purna.HRManagementAPIV3.controller.repository.EducationQualificationRepository;
import lk.purna.HRManagementAPIV3.controller.request.EducationQualificationRq;
import lk.purna.HRManagementAPIV3.controller.response.EducationQualificationResponse;
import lk.purna.HRManagementAPIV3.controller.response.EducationQualificationResponse2;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;
import lk.purna.HRManagementAPIV3.service.EducationQualificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EducationQualificationImpl implements EducationQualificationService {

    private EducationQualificationRepository educationQualificationRepository;

    public EducationQualificationResponse add(EducationQualificationRq educationQualificationRq){

        Education education = new Education();

        education.setDegree(educationQualificationRq.getDegree());
        education.setStartDate(educationQualificationRq.getStartDate());
        education.setEndDate(educationQualificationRq.getEndDate());
        education.setInstitute(educationQualificationRq.getInstitute());

        educationQualificationRepository.save(education);

        EducationQualificationResponse educationQualificationResponse = new EducationQualificationResponse();

        educationQualificationResponse.setId(education.getId());
        educationQualificationResponse.setDegree(education.getDegree());
        educationQualificationResponse.setStartDate(education.getStartDate());
        educationQualificationResponse.setEndDate(education.getEndDate());
        educationQualificationResponse.setInstitute(education.getInstitute());

        return educationQualificationResponse;
    }

    @Override
    public EducationQualificationResponse get(Long id) {

        Optional<Education>educationOptional = educationQualificationRepository.findById(id);

        EducationQualificationResponse educationQualificationResponse = new EducationQualificationResponse();

        if (educationOptional.isPresent()){

            Education education = educationOptional.get();

            educationQualificationResponse.setId(education.getId());
            educationQualificationResponse.setInstitute(education.getInstitute());
            educationQualificationResponse.setDegree(education.getDegree());
            educationQualificationResponse.setStartDate(education.getStartDate());
            educationQualificationResponse.setEndDate(education.getEndDate());

            return educationQualificationResponse;
        }

        return null;
    }

    @Override
    public List<EducationQualificationResponse2> getAll() {
        List<Education> educationList = educationQualificationRepository.findAll();

        return educationList.stream().map(education -> EducationQualificationResponse2.builder().id(education.getId()).degree(education.getDegree()).institute(education.getInstitute()).startDate(education.getStartDate()).endDate(education.getEndDate()).build()).toList();
    }

    @Override
    public EducationQualificationResponse update(Long id,EducationQualificationRq educationQualificationRq) {

        Optional<Education> educationOptional = educationQualificationRepository.findById(id);
        EducationQualificationResponse educationQualificationResponse = new EducationQualificationResponse();

        if (educationOptional.isPresent()){

            Education education = educationOptional.get();

            education.setId(education.getId());
            education.setInstitute(educationQualificationRq.getInstitute());
            education.setDegree(educationQualificationRq.getDegree());
            education.setStartDate(educationQualificationRq.getStartDate());
            education.setEndDate(educationQualificationRq.getEndDate());

            educationQualificationRepository.save(education);



            educationQualificationResponse.setId(education.getId());
            educationQualificationResponse.setInstitute(education.getInstitute());
            educationQualificationResponse.setDegree(education.getDegree());
            educationQualificationResponse.setStartDate(education.getStartDate());
            educationQualificationResponse.setEndDate(education.getEndDate());


        }

        return educationQualificationResponse;
    }

    @Override
    public MessageResponse delete(Long id) {

        educationQualificationRepository.deleteById(id);

        MessageResponse messageResponse = new MessageResponse();

        messageResponse.setMessage("Education Qulification "+id+" deleted");

        return  messageResponse;
    }


}
