package ru.itmo.inceptionservice.model.dreams.participant.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itmo.inceptionservice.model.dreams.stage.entity.DreamStage;
import ru.itmo.inceptionservice.model.user.entity.PersonData;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class DreamStageParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID externalId;

    private String stageRole;

    private Boolean isMustAlive;

    @OneToOne
    private PersonData personData;

    @ManyToMany
    private List<DreamStage> stages;
}
