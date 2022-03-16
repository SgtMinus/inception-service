package ru.itmo.inceptionservice.utils.generator.factory;

import com.github.javafaker.Faker;
import ru.itmo.inceptionservice.model.dreams.participant.entity.DreamStageParticipant;
import ru.itmo.inceptionservice.model.user.entity.PersonData;
import ru.itmo.inceptionservice.model.user.entity.User;
import ru.itmo.inceptionservice.model.user.entity.UserRole;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class UserStubFactory extends Faker {

    public User generate() {
        return User.builder()
                .email(internet().emailAddress())
                .password(internet().password())
                .role(generateRandomRole())
                .personData(generateRandomData())
                .build();
    }

    public User generate(UserRole role){
        return User.builder()
                .email(internet().emailAddress())
                .password(internet().password())
                .role(role)
                .personData(generateRandomData())
                .build();
    }

    public DreamStageParticipant generateParticipants(){
        return DreamStageParticipant.builder()
                .isMustAlive(true)
                .stageRole(hobbit().thorinsCompany())
                .stages(null)
                .build();
    }

    private UserRole generateRandomRole() {
        return Arrays.stream(UserRole.values())
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        collected -> {
                            Collections.shuffle(collected);
                            return collected.stream();
                        }))
                .findFirst().get();
    }

    private PersonData generateRandomData() {
        return PersonData.builder()
                .age(random().nextInt(50)+10)
                .name(name().name())
                .surname(name().lastName())
                .city(address().city())
                .build();
    }

}