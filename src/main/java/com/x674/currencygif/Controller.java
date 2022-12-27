package com.x674.currencygif;

import com.x674.currencygif.currency.CurrencyClient;
import com.x674.currencygif.currency.model.Currency;
import com.x674.currencygif.gif.model.GIF;
import com.x674.currencygif.gif.GIFClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class Controller {

    private final CurrencyClient currencyClient;
    private final GIFClient gifClient;
    @Value("${application.api.currency.AppID}")
    private String exchangeAppID;
    @Value("${application.api.giphy.AppID}")
    private String giphyAppID;
    public Controller(CurrencyClient currencyClient, GIFClient gifClient) {
        this.currencyClient = currencyClient;
        this.gifClient = gifClient;
    }

    @GetMapping("/differentCurrency/{currency}")
    public String GetDifferentCurrency(@PathVariable String currency) {
        Currency currentCurrency = currencyClient.GetCurrencyByDate(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE), exchangeAppID, currency);
        Currency previosDayCurrency = currencyClient
                .GetCurrencyByDate(LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ISO_DATE), exchangeAppID, currency);
        if (currentCurrency.getCurrency(currency) < previosDayCurrency.getCurrency(currency))
        {
            GIF gif = gifClient.GetRandomGifByTag(giphyAppID, "broke");
            return String.format("<img src=\"%s\">",gif.getUrlGif()) ;
        }

        GIF gif = gifClient.GetRandomGifByTag(giphyAppID, "rich");
        return String.format("<img src=\"%s\">",gif.getUrlGif()) ;
    }
}