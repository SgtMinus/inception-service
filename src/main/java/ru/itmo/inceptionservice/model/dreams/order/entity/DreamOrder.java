package ru.itmo.inceptionservice.model.dreams.order.entity;

import lombok.Data;
import ru.itmo.inceptionservice.model.dreams.dream.entity.Dream;
import ru.itmo.inceptionservice.model.user.entity.PersonData;
import ru.itmo.inceptionservice.model.user.entity.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class DreamOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private UUID externalId;

    @OneToOne(optional = false)
    private PersonData targetUserInfo;

    @OneToOne(optional = false)
    private User customer;

    private LocalDate finishDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToOne
    private Dream orderProcessing;
}
