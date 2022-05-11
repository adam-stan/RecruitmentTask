package pl.recruitmenttask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.recruitmenttask.service.RateService;

import java.util.List;

@RestController
public class RateController {

    @Autowired
    RateService rateService;

    @GetMapping("/ratesEurUsd")
    public String getRates() {
        return rateService.getRatesEurUsd();
    }

    @GetMapping("/allSearches")
    public List<String> getAllSearches() {
        return rateService.getListOfRates();
    }
}
