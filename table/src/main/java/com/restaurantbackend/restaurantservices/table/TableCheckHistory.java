package com.restaurantbackend.restaurantservices.table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class TableCheckHistory {
    @Id
    @SequenceGenerator(
            name = "table_id_sequence",
            sequenceName = "table_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "table_id_sequence"
    )
    private Integer id;
    private Integer guestId;

}
