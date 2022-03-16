package ru.itmo.inceptionservice.utils.generator.factory;

import com.github.javafaker.Faker;
import ru.itmo.inceptionservice.model.dreams.dream.entity.Dream;
import ru.itmo.inceptionservice.model.dreams.participant.entity.DreamStageParticipant;
import ru.itmo.inceptionservice.model.dreams.stage.entity.DreamStage;
import ru.itmo.inceptionservice.model.dreams.strategy.entity.DreamStrategy;
import ru.itmo.inceptionservice.model.dreams.test.entity.DreamStrategyTest;
import ru.itmo.inceptionservice.model.user.entity.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DreamStubFactory extends Faker {

    public Dream generate(User mainArch, List<DreamStageParticipant> participants){
        return Dream.builder()
                .mainArchitect(mainArch)
                .strategies(List.of(generateStrategy(mainArch, participants), generateStrategy(mainArch, participants)))
                .resultSuccessProbability((float) Math.random())
                .build();
    }

    public DreamStrategy generateStrategy(User architect, List<DreamStageParticipant> participants){
        return DreamStrategy.builder()
                .stages(List.of(generateStage(architect,participants), generateStage(architect, participants)))
                .tests(List.of(generateTest(),generateTest(),generateTest()))
                .build();
    }

    public DreamStrategyTest generateTest(){
        return DreamStrategyTest.builder()
                .createdAt(LocalDateTime.now())
                .description(hobbit().quote())
                .dreamStrategyChainSuccessProbability(123.3d)
                .build();
    }

    public DreamStage generateStage(User architect, List<DreamStageParticipant> participants){
        return DreamStage.builder()
                .architect(architect)
                .description(hobbit().quote())
                .stageNumber(new Random(21).nextLong())
                .next(generateLastStage(architect, participants))
                .participants(participants)
                .build();
    }

    public DreamStage generateLastStage(User architect,List<DreamStageParticipant> participants){
        return DreamStage.builder()
                .architect(architect)
                .description(hobbit().quote())
                .stageNumber(new Random(21).nextLong())
                .next(null)
                .participants(participants)
                .build();
    }

}
