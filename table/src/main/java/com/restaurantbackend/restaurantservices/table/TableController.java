package com.restaurantbackend.restaurantservices.table;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api1/v1/table-check")
@AllArgsConstructor
@Slf4j
public class TableController {

    private final TableCheckService tableCheckService;

    @GetMapping(path = "{guestId}")
    public TableCheckResponse isRegistered(
            @PathVariable("guestId") Integer guestID) {
        boolean canRegisterGuest = tableCheckService.
                canRegisterGuest(guestID);
        log.info("table check request for guest {}", guestID);

        return new TableCheckResponse(canRegisterGuest);
    }


    @PostMapping
    public void createTable(@RequestBody TableAddRequest tableAddRequest) {
        log.info("new table creation {}", tableAddRequest);
        tableCheckService.createTable(tableAddRequest);
    }


}
