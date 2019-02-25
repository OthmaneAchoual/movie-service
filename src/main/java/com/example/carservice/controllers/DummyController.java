package com.example.carservice.controllers;

import java.io.IOException;
import java.util.List;

import com.example.carservice.services.DummyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dummy")
public class DummyController {

  @Autowired
  private DummyService dummyService;

  @GetMapping("/file")
  public String file() throws IOException {
    return this.dummyService.fileContent();
  }

  @GetMapping("/greater")
  public List<Integer> greaterThan(@RequestParam("threshold") int threshold) {
    return dummyService.sortedGreaterThan(threshold);
  }

}