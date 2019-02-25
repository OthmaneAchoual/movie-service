package com.example.carservice.services;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class DummyService {

  private static final Integer SIZE = 1024;
  private static List<Integer> integers = Arrays.asList(
    0, 10, 25, 36, 47, 12, 785, 126, 1, 2387
  );

  public String fileContent() throws IOException {
    try (FileReader reader = new FileReader(ResourceUtils.getFile("classpath:test.txt"))) {
      try (StringWriter writer = new StringWriter()) {
        char[] buffer = new char[SIZE];
        int numCharsRead;
        while ((numCharsRead = reader.read(buffer, 0, SIZE)) != -1) {
          writer.write(buffer, 0, numCharsRead);
        }
        return writer.toString();
      }
    }
  }

  public List<Integer> sortedGreaterThan(int threshold) {
    return integers.stream()
      .filter(val -> val > threshold)
      .sorted(Comparator.naturalOrder())
      .collect(Collectors.toList());
  }
}