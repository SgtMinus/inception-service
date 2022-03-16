package ru.itmo.inceptionservice.service.dreams.strategy;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.itmo.inceptionservice.controller.dreams.strategy.dto.AddNewStrategyDTO;
import ru.itmo.inceptionservice.model.dreams.strategy.entity.DreamStrategy;
import ru.itmo.inceptionservice.model.dreams.strategy.repository.DreamStrategyRepository;
import ru.itmo.inceptionservice.service.dreams.strategy.factory.DreamStrategyFactory;
import ru.itmo.inceptionservice.service.user.userservice.UserService;

import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Service
public class DreamStrategyServiceImpl implements DreamStrategyService {

    private final DreamStrategyRepository strategyRepository;
    private final DreamStrategyFactory strategyFactory;
    private final UserService userService;

    @Override
    public List<DreamStrategy> getAll(UUID dreamId) {
        return strategyRepository
                .findAllByDream_ExternalId(dreamId)
                .orElse(List.of());
    }

    @Override
    public DreamStrategy addNew(AddNewStrategyDTO dto) {
        return strategyRepository.saveAndFlush(strategyFactory.create(dto));
    }

    @Override
    public DreamStrategy getByExternalId(UUID uuid) {
        return strategyRepository
                .findByExternalId(uuid)
                .orElseThrow();
    }
}
