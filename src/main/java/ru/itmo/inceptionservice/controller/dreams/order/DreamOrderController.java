package ru.itmo.inceptionservice.controller.dreams.order;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.inceptionservice.controller.dreams.order.dto.CreateDreamOrderDTO;
import ru.itmo.inceptionservice.controller.dreams.order.dto.DreamOrderDTO;
import ru.itmo.inceptionservice.service.dreams.order.DreamOrderService;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@RequiredArgsConstructor
@RequestMapping("/dream/order")
@RestController
public class DreamOrderController {

    private final DreamOrderService dreamOrderService;

    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        log.info("get all orders");
        return ResponseEntity.ok(
                dreamOrderService.getAllOrders()
                        .stream()
                        .map(DreamOrderDTO::createFrom)
                        .collect(Collectors.toList())
        );
    }

    @PostMapping
    public ResponseEntity<?> createNewOrder(@RequestBody CreateDreamOrderDTO dto,
                                            HttpServletRequest request) {
        var email = (String) request.getAttribute("email");
        log.info("start create dream order {} from user {}", dto, email);
        return ResponseEntity.ok(DreamOrderDTO.createFrom(dreamOrderService.createNewOrder(email, dto)));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<?> getByExternalId(@PathVariable UUID uuid) {
        log.info("get indo about order {}", uuid);
        return ResponseEntity.ok(DreamOrderDTO.createFrom(dreamOrderService.getByExternalId(uuid)));
    }

    @PostMapping("/{uuid}")
    public ResponseEntity<?> acceptOrder(@PathVariable UUID uuid,
                                         HttpServletRequest request) {
        var email = (String) request.getAttribute("email");
        log.info("architect {} accept order {}", email, uuid);
        return ResponseEntity.ok(DreamOrderDTO.createFrom(dreamOrderService.accept(email, uuid)));
    }
}
