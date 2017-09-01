package com.vysu0216.mvc;

import com.vysu0216.mvc.service.SpitterService;

import javax.inject.Inject;

/**
 * Created by vysu0216 on 31-Aug-17.
 */
public class HomeController {

    public static final int DEFAULT_SPITTER_PER_PAGE = 25;
    private SpitterService spitterService;

    @Inject
    public HomeController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }
}
