package org.example.test_task.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.test_task.api.utils.JsonViews;
import org.example.test_task.model.RateClass;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RateClassDTO {
    @JsonView(JsonViews.IdName.class)
    private String name;
    @JsonView(JsonViews.IdName.class)
    private String rate;
    @JsonView(JsonViews.IdName.class)
    private String date;
    @JsonView(JsonViews.IdName.class)
    private String time;
    @JsonIgnore
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    @JsonIgnore
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");


    public RateClassDTO(RateClass rate) {
        this.name = rate.getName();
        this.rate = rate.getValue().toString();
        this.date = sdf.format(rate.getDate());
        this.time = dtf.format(rate.getTime());
    }
}

