package ru.itmo.inceptionservice.service.dreams.stage;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.itmo.inceptionservice.controller.dreams.stage.dto.AddNewStageDTO;
import ru.itmo.inceptionservice.model.dreams.stage.entity.DreamStage;
import ru.itmo.inceptionservice.model.dreams.stage.repository.DreamStageRepository;
import ru.itmo.inceptionservice.service.dreams.stage.factory.DreamStageFactory;
import ru.itmo.inceptionservice.service.user.userservice.UserService;

import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Service
public class DreamStageServiceImpl implements DreamStageService {

    private final DreamStageRepository stageRepository;
    private final DreamStageFactory stageFactory;
    private final UserService userService;

    @Override
    public List<DreamStage> getAllStages(UUID dreamId) {
        return null;
    }

    @Override
    public DreamStage createStage(String email, AddNewStageDTO dto) {
        var architect = userService.getUserByEmail(email);
        return stageRepository.saveAndFlush(
                stageFactory.create(architect, dto)
        );
    }

    @Override
    public DreamStage getByExternalId(UUID uuid) {
        return stageRepository.findByExternalId(uuid)
                .orElseThrow();
    }
}
