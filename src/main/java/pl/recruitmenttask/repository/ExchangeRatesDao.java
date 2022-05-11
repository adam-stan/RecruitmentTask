package pl.recruitmenttask.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.recruitmenttask.domain.ExchangeRates;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ExchangeRatesDao extends CrudRepository<ExchangeRates, Integer> {

}