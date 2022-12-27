package com.x674.currencygif.gif.model;

import com.fasterxml.jackson.databind.JsonNode;

public class GIF {

    public JsonNode data;

    public String getUrlGif() {
        return data.get("images").get("downsized_medium").get("url").textValue();
    }
}
