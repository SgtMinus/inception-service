package ru.itmo.inceptionservice.model.dreams.dream.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itmo.inceptionservice.model.dreams.strategy.entity.DreamStrategy;
import ru.itmo.inceptionservice.model.user.entity.User;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Dream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID externalId;

    @OneToOne
    private User mainArchitect;

    private float resultSuccessProbability;

    @OneToMany(cascade = CascadeType.ALL)
    private List<DreamStrategy> strategies;
}
