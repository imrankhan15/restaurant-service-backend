package com.amigoscode.table;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class TableCheckServiceTest {

    @Mock private TableCheckHistoryRepository tableCheckHistoryRepository ;

    private TableCheckService underTest;

    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new TableCheckService(tableCheckHistoryRepository);

    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canRegisterGuestTest() {
        // given
        Integer guestID = 5;
        // when

        Boolean b = underTest.canRegisterGuest(guestID);
        //then

        Boolean result = false;
        LinkedList e = (LinkedList) tableCheckHistoryRepository.findAll();
        for (Object g : e ) {
            TableCheckHistory t = (TableCheckHistory) g;
            if(t.getGuestId() == 0){

                result =  true;
            }

        }


        assertThat(result).isEqualTo(b);
    }




}