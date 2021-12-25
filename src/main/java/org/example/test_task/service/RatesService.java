package org.example.test_task.service;

import lombok.RequiredArgsConstructor;
import org.example.test_task.api.utils.RateDTOConverter;
import org.example.test_task.model.RateClass;
import org.example.test_task.model.dto.RateClassDTO;
import org.example.test_task.repository.RatesRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RatesService {

    private final RatesRepository ratesRepository;

    public List<?> getAllRates() {
        return getListWithRatesDTO(ratesRepository.findAll());
    }

    public void saveRate(RateClass rate) {
        ratesRepository.save(rate);
    }

    public List<?> searchByName(String name) {
        return getListWithRatesDTO(ratesRepository.findByName(name));
    }

    public List<?> searchByDate(Date date) {
        return getListWithRatesDTO(ratesRepository.findByDate(date));
    }

    public List<?> searchByTwoParam(String name, Date date) {
        return getListWithRatesDTO(ratesRepository.findByNameAndDate(name, date));
    }

    private List<RateClassDTO> getListWithRatesDTO(List<RateClass> source) {
        return source.stream().map(RateDTOConverter::getConversion).collect(Collectors.toList());
    }
}
