package ru.itmo.inceptionservice.controller.dreams.strategy;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.inceptionservice.controller.dreams.strategy.dto.AddNewStrategyDTO;
import ru.itmo.inceptionservice.controller.dreams.strategy.dto.DreamStrategyDTO;
import ru.itmo.inceptionservice.service.dreams.strategy.DreamStrategyService;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@RequiredArgsConstructor
@RequestMapping("/dream/strategy")
@RestController
public class DreamStrategyController {

    private final DreamStrategyService dreamStrategyService;

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam UUID dreamId){
        log.info("start get all strategies for dream {}", dreamId);
        return ResponseEntity.ok(
                dreamStrategyService.getAll(dreamId)
                        .stream()
                        .map(DreamStrategyDTO::createFrom)
                        .collect(Collectors.toList())
        );
    }

    @PostMapping
    public ResponseEntity<?> addNewStrategy(@RequestBody AddNewStrategyDTO dto,
                                            HttpServletRequest request){
        var email = (String) request.getParameter("email");
        log.info("Architect {} add new strategy", email);
        return ResponseEntity.ok(DreamStrategyDTO.createFrom(dreamStrategyService.addNew(dto)));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<?> getStrategyByUUID(@PathVariable UUID uuid){
        log.info("get strategy by uuid {}", uuid);
        return ResponseEntity.ok(DreamStrategyDTO.createFrom(dreamStrategyService.getByExternalId(uuid)));
    }

}
