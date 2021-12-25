package org.example.test_task.api.utils;

import org.example.test_task.model.RateClass;
import org.example.test_task.model.dto.RateClassDTO;

public class RateDTOConverter {
    private RateDTOConverter() {
    }

    public static RateClassDTO getConversion(RateClass rate) {
        return new RateClassDTO(rate);
    }
}
