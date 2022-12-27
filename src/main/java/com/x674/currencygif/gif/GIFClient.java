package com.x674.currencygif.gif;

import com.x674.currencygif.gif.model.GIF;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "giphy-service", url = "${application.api.giphy.Host}")
public interface GIFClient {

    @GetMapping(value = "gifs/random")
    GIF GetRandomGifByTag(@RequestParam String api_key, @RequestParam String tag);
}
