package org.example.test_task.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "rates")
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RateClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rate_name")
    private String name;

    @Column(name = "rate_value")
    private BigDecimal value;

    @Column(name = "rate_date")
    private Date date;

    @Column(name = "rate_time")
    private LocalTime time;
}
