package ru.itmo.inceptionservice.controller.dreams.dream;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.inceptionservice.controller.dreams.dream.dto.DreamDTO;
import ru.itmo.inceptionservice.service.dreams.dream.DreamService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@RequiredArgsConstructor
@RequestMapping("/dream")
@RestController
public class DreamController {

    private final DreamService dreamService;

    @GetMapping
    public ResponseEntity<?>getAllDreams(){
        log.info("start get all dreams");
        return ResponseEntity.ok(
                dreamService.getAllDreams()
                .stream()
                .map(DreamDTO::createFrom)
                .collect(Collectors.toList())
        );
    }

    @PostMapping
    public ResponseEntity<?> createNewDream(){
        return null;
    }


    @GetMapping("/{uuid}")
    public ResponseEntity<?> getDreamById(@PathVariable UUID uuid){
        log.info("get dream by uuid {}", uuid);
        return ResponseEntity.ok(DreamDTO.createFrom(dreamService.getByExternalId(uuid)));
    }

}
