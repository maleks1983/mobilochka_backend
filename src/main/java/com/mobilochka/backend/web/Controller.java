package com.mobilochka.backend.web;


import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
public class Controller {
    public List<String> list = Arrays.asList("Menu1", "Menu2");


}
