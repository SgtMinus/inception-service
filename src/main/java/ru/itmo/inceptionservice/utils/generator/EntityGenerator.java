package ru.itmo.inceptionservice.utils.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itmo.inceptionservice.model.dreams.dream.entity.Dream;
import ru.itmo.inceptionservice.model.dreams.dream.repository.DreamRepository;
import ru.itmo.inceptionservice.model.dreams.participant.entity.DreamStageParticipant;
import ru.itmo.inceptionservice.model.user.entity.User;
import ru.itmo.inceptionservice.model.user.entity.UserRole;
import ru.itmo.inceptionservice.model.user.repository.UserRepository;
import ru.itmo.inceptionservice.utils.generator.factory.DreamStubFactory;
import ru.itmo.inceptionservice.utils.generator.factory.UserStubFactory;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class EntityGenerator  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DreamRepository dreamRepository;

    private final UserStubFactory uF = new UserStubFactory();
    private final DreamStubFactory dF = new DreamStubFactory();


    @PostConstruct
    public void generate(){
        var users = userRepository.saveAll(generateUsers(100));
        dreamRepository.saveAll(generateDreams(100, users));
    }


    private List<User> generateUsers(int count){
        final var users = new ArrayList<User>();
        for(int i = 0; i < count; i++){
            users.add(uF.generate());
        }
        return users;
    }

    private List<Dream> generateDreams(int count, List<User> userList){
        final var dreams = new ArrayList<Dream>();
        final var part = new ArrayList<DreamStageParticipant>();
        var mainArch = userList
                .stream()
                .filter(u -> u.getRole().equals(UserRole.MAIN_ARCHITECT))
                .findFirst()
                .orElse(uF.generate(UserRole.MAIN_ARCHITECT));

        for(int i = 0 ; i < count; i++){
            part.add(uF.generateParticipants());
        }

        for(int i = 0; i < count; i++){
            dreams.add(dF.generate(mainArch, part));
        }
        return dreams;
    }

}
