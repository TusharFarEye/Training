package com.fareye.training.controller;

import com.fareye.training.utility.FetchApplicationProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Properties;

@RestController
public class PropertyController {
    @Autowired
    FetchApplicationProperty appProps;
    @GetMapping("/app-properties")
    public Properties hello() throws IOException {
        return appProps.getPropValues();
    }
}