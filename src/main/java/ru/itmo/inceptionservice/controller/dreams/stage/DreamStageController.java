package ru.itmo.inceptionservice.controller.dreams.stage;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.inceptionservice.controller.dreams.order.dto.DreamOrderDTO;
import ru.itmo.inceptionservice.controller.dreams.stage.dto.AddNewStageDTO;
import ru.itmo.inceptionservice.controller.dreams.stage.dto.DreamStageDTO;
import ru.itmo.inceptionservice.service.dreams.stage.DreamStageService;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;
import java.util.stream.Collectors;
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/dream/stage")
@RestController
public class DreamStageController {

    private final DreamStageService dreamStageService;

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam UUID dreamId){
        log.info("get all stages");
        return ResponseEntity.ok(
                dreamStageService.getAllStages(dreamId)
                        .stream()
                        .map(DreamStageDTO::createFrom)
                        .collect(Collectors.toList())
        );
    }

    @PostMapping
    public ResponseEntity<?> addNewStage(@RequestBody AddNewStageDTO dto,
                                         HttpServletRequest request){
        var email = (String) request.getParameter("email");
        log.info("start create stage {} from architect {}", dto, email);
        return ResponseEntity.ok(DreamStageDTO.createFrom(dreamStageService.createStage(email,dto)));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<?> getStageByUUID(@PathVariable UUID uuid){
        log.info("get stage {} info", uuid);
        return ResponseEntity.ok(DreamStageDTO.createFrom(dreamStageService.getByExternalId(uuid)));
    }

}
