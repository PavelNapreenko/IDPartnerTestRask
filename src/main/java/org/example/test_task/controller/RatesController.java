package org.example.test_task.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.example.test_task.api.utils.JsonViews;
import org.example.test_task.service.RatesService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rates")
public class RatesController {

    private final RatesService ratesService;

    public RatesController(RatesService ratesService) {
        this.ratesService = ratesService;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<?> getAllRates() {
        return ratesService.getAllRates();
    }

    @GetMapping(value = "/search-by-name", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(JsonViews.IdName.class)
    public List<?> searchByName(@RequestParam(name = "name") String name) {
        if (!name.isEmpty()) {
            return ratesService.searchByName(name);
        }
        return new ArrayList<>();
    }

    @GetMapping(value = "/search-by-date", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(JsonViews.IdName.class)
    public List<?> searchByDate(@RequestParam(name = "date") String date) throws ParseException {
        if (!date.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date rateDate = sdf.parse(date);
            return ratesService.searchByDate(rateDate);
        }
        return new ArrayList<>();
    }

    @GetMapping(value = "/search-by-name-and-date", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(JsonViews.IdName.class)
    public List<?> searchByNameAndDate(@RequestParam(name = "name") String name,
                                       @RequestParam(name = "date") String date) throws ParseException {
        if (!name.isEmpty() && !date.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date rateDate = sdf.parse(date);
            return ratesService.searchByTwoParam(name, rateDate);
        }
        return new ArrayList<>();
    }
}
