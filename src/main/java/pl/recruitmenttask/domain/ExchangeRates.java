package pl.recruitmenttask.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@NoArgsConstructor
@ToString
public class ExchangeRates {

    private int id;
    private String response;
    private String DateAndTimeOfCheck;

    public ExchangeRates(String response, String DateAndTimeOfCheck) {
        this.response = response;
        this.DateAndTimeOfCheck = DateAndTimeOfCheck;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    public String getResponse() {
        return response;
    }

    public String getDateAndTimeOfCheck() {
        return DateAndTimeOfCheck;
    }
}
