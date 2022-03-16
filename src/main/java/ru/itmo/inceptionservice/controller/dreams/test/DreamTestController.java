package ru.itmo.inceptionservice.controller.dreams.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.inceptionservice.controller.dreams.test.dto.DreamTestDTO;
import ru.itmo.inceptionservice.model.dreams.test.entity.DreamStrategyTest;
import ru.itmo.inceptionservice.service.dreams.test.DreamTestService;

import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@RequiredArgsConstructor
@RequestMapping("/dream/test")
@RestController
public class DreamTestController {

    private final DreamTestService dreamTestService;

    @GetMapping("/{uuid}")
    public ResponseEntity<?> getTestResult(@PathVariable UUID uuid){
        log.info("start create info about test {}", uuid);
        return ResponseEntity.ok(DreamTestDTO.createFrom(dreamTestService.getByExternalId(uuid)));
    }

    @GetMapping
    public ResponseEntity<?> getAllTestsFotDream(@RequestParam UUID dreamId){
        log.info("get all tests for dream {}", dreamId);
        return ResponseEntity.ok(
                dreamTestService.getAllByDreamId(dreamId)
                        .stream()
                        .map(DreamTestDTO::createFrom)
                        .collect(Collectors.toList())
        );
    }

}
