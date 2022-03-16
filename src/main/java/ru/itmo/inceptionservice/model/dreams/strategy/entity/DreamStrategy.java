package ru.itmo.inceptionservice.model.dreams.strategy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itmo.inceptionservice.model.dreams.dream.entity.Dream;
import ru.itmo.inceptionservice.model.dreams.stage.entity.DreamStage;
import ru.itmo.inceptionservice.model.dreams.test.entity.DreamStrategyTest;
import ru.itmo.inceptionservice.model.user.entity.User;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class DreamStrategy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID externalId;

    @ManyToOne
    private Dream dream;

    @OneToMany(cascade = CascadeType.ALL)
    private List<DreamStrategyTest> tests;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<DreamStage> stages;
}
