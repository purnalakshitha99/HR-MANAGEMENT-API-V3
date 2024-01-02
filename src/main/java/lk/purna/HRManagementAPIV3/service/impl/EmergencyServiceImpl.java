package lk.purna.HRManagementAPIV3.service.impl;

import lk.purna.HRManagementAPIV3.controller.model.Emergency;
import lk.purna.HRManagementAPIV3.controller.repository.EmergencyRepository;
import lk.purna.HRManagementAPIV3.controller.request.EmergencyContactRq;
import lk.purna.HRManagementAPIV3.controller.response.EmergencyContactResponse;
import lk.purna.HRManagementAPIV3.controller.response.EmergencyContactResponse2;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;
import lk.purna.HRManagementAPIV3.service.EmergencyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmergencyServiceImpl implements EmergencyService {

    private EmergencyRepository emergencyRepository;

    @Override
    public EmergencyContactResponse add(EmergencyContactRq emergencyContactRq) {

        Emergency emergency = new Emergency();

        emergency.setNum1(emergencyContactRq.getNum1());
        emergency.setNum2(emergencyContactRq.getNum2());

        emergencyRepository.save(emergency);

        EmergencyContactResponse emergencyContactResponse = new EmergencyContactResponse();

        emergencyContactResponse.setId(emergency.getId());
        emergencyContactResponse.setNum1(emergency.getNum1());
        emergencyContactResponse.setNum2(emergency.getNum2());

        return emergencyContactResponse;
    }

    @Override
    public EmergencyContactResponse get(Long id) {

         Optional<Emergency> emergencyOptional = emergencyRepository.findById(id);

         if (emergencyOptional.isPresent()){

             Emergency emergency = emergencyOptional.get();

            EmergencyContactResponse emergencyContactResponse = new EmergencyContactResponse();

            emergencyContactResponse.setId(emergency.getId());
            emergencyContactResponse.setNum1(emergency.getNum1());
            emergencyContactResponse.setNum2(emergency.getNum2());

            return emergencyContactResponse;
         }

         return null;
    }

    @Override
    public EmergencyContactResponse update(Long id, EmergencyContactRq emergencyContactRq) {

        Optional<Emergency> emergencyOptional = emergencyRepository.findById(id);

        if (emergencyOptional.isPresent()){

            Emergency emergency = emergencyOptional.get();

            emergency.setId(emergency.getId());
            emergency.setNum1(emergencyContactRq.getNum1());
            emergency.setNum2(emergencyContactRq.getNum2());

            emergencyRepository.save(emergency);

            EmergencyContactResponse emergencyContactResponse = new EmergencyContactResponse();

            emergencyContactResponse.setId(emergency.getId());
            emergencyContactResponse.setNum1(emergency.getNum1());
            emergencyContactResponse.setNum2(emergency.getNum2());

            return emergencyContactResponse;
        }

        return null;
    }

    @Override
    public List<EmergencyContactResponse> getAll() {

        List<Emergency> emergencyList = emergencyRepository.findAll();
        List<EmergencyContactResponse> emergencyContactResponseList = new ArrayList<>();

        for(Emergency emergency: emergencyList){

            EmergencyContactResponse emergencyContactResponse = new EmergencyContactResponse();

            emergencyContactResponse.setId(emergency.getId());
            emergencyContactResponse.setNum1(emergency.getNum1());
            emergencyContactResponse.setNum2(emergency.getNum2());

            emergencyContactResponseList.add(emergencyContactResponse);


        }

        return emergencyContactResponseList;

    }


    public List<EmergencyContactResponse2> getAll2(){


        System.out.println("version 2 get all2");
        List<Emergency> emergencyList = emergencyRepository.findAll();

        return emergencyList.stream().map(emergency -> EmergencyContactResponse2.builder().id(emergency.getId()).num1(emergency.getNum1()).num2(emergency.getNum2()).build()).toList();
    }

    @Override
    public MessageResponse delete(Long id) {

        emergencyRepository.deleteById(id);

        MessageResponse messageResponse = new MessageResponse();

         messageResponse.setMessage("deleted by "+id+" emergency contacts");

         return messageResponse;
    }
}
