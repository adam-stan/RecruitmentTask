package pl.recruitmenttask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.recruitmenttask.domain.ExchangeRates;
import pl.recruitmenttask.repository.ExchangeRatesDao;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class RateService {

    private RestTemplate restTemplate = new RestTemplate();
    private static final String URL = "https://www.frankfurter.app/";

    @Autowired
    private ExchangeRatesDao exchangeRatesDao;

    public String getRatesEurUsd() {

        String response = restTemplate.getForObject(URL + "{date}?to={currency}", String.class, "2022-05-04", "USD");

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatted = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = dateTime.format(formatted);

        ExchangeRates exchangeRates = new ExchangeRates(response, formattedDate);
        System.out.println(exchangeRates);

        exchangeRatesDao.save(exchangeRates);

        return exchangeRates.toString();
    }

    public List<String> getListOfRates() {

        List<String> listOfSearches = new ArrayList<>();

        Iterable<ExchangeRates> object = exchangeRatesDao.findAll();

        for(ExchangeRates o: object) {
            listOfSearches.add(o.toString());
        }

        listOfSearches.forEach(System.out::println);

        return listOfSearches;
    }
}
