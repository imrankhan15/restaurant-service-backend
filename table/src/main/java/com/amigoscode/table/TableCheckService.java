package com.amigoscode.table;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@AllArgsConstructor
public class TableCheckService {

    private final TableCheckHistoryRepository tableCheckHistoryRepository;

    public boolean canRegisterGuest(Integer guestId) {

        ArrayList e = (ArrayList) tableCheckHistoryRepository.findAll();
        for (Object g : e ) {
            TableCheckHistory t = (TableCheckHistory) g;
            if(t.getGuestId() == 0){
                t.setGuestId(guestId);
                tableCheckHistoryRepository.saveAndFlush(t);
                return true;
            }

        }

        return false;
    }

    public void createTable(TableAddRequest request) {


        TableCheckHistory table = TableCheckHistory.builder()

                .guestId(0)
                .build();
        tableCheckHistoryRepository.saveAndFlush(table);

    }

}
