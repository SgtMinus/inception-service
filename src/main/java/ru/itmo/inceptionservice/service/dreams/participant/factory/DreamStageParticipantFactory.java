package ru.itmo.inceptionservice.service.dreams.participant.factory;

import org.springframework.stereotype.Component;
import ru.itmo.inceptionservice.controller.dreams.stage.dto.DreamStageParticipantDTO;
import ru.itmo.inceptionservice.model.dreams.participant.entity.DreamStageParticipant;
import ru.itmo.inceptionservice.model.user.entity.PersonData;

import java.util.UUID;

@Component
public class DreamStageParticipantFactory {

    public DreamStageParticipant create(DreamStageParticipantDTO dto){
        var personData = dto.getPersonData();
        return DreamStageParticipant.builder()
                .stageRole(dto.getStageRole())
                .isMustAlive(dto.getIsMustAlive())
                .personData(
                        PersonData.builder()
                                .age(personData.getAge())
                                .city(personData.getCity())
                                .name(personData.getName())
                                .surname(personData.getSurname())
                                .build()
                )
                .externalId(UUID.randomUUID())
                .build();
    }

}
