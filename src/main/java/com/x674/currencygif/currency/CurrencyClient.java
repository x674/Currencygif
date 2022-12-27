package com.x674.currencygif.currency;

import com.x674.currencygif.currency.model.Currency;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "openexchangerates-service", url = "${application.api.currency.Host}")
public interface CurrencyClient {

    @GetMapping(value = "latest.json")
    Currency GetCurrentCurrency(@RequestParam String app_id, @RequestParam String symbols);

    @GetMapping(value = "latest.json")
    Currency GetCurrencyByDate(@PathVariable String date, @RequestParam String app_id, @RequestParam String symbols);

}