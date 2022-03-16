package ru.itmo.inceptionservice.model.dreams.stage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itmo.inceptionservice.model.dreams.participant.entity.DreamStageParticipant;
import ru.itmo.inceptionservice.model.user.entity.User;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DreamStage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID externalId;

    private Long stageNumber;

    private String description;

    @OneToOne
    private User architect;

    @OneToOne(cascade = CascadeType.ALL)
    private DreamStage next;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<DreamStageParticipant> participants;
}
