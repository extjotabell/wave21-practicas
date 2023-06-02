package com.example.generico.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Formatter {
  /**
   * Recibe un path para convertir en una List
   * @param path
   * @return
   * @param <T>
   */
  public static <T> T jsonToObject(final String path) {
    try {
      ObjectMapper om = new ObjectMapper();
      final File json = ResourceUtils.getFile(path);

      return om.readValue(json, new TypeReference<>() {});
    } catch(IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static <T> List<T> jsonToArrayObject(final String path) {

    try {
      ObjectMapper om = new ObjectMapper();
      final File json = ResourceUtils.getFile(path);

      return om.readValue(json, new TypeReference<>() {});
    } catch(IOException e) {
      e.printStackTrace();
      return new ArrayList<>();
    }
  }
}
