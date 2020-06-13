package framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileWorker {

  private static FileInputStream fis;
  private static Properties property = new Properties();

  public FileWorker(String fileName) {
    try {
      fis = new FileInputStream("src/test/resources/" + fileName);
      property.load(fis);
    } catch (IOException e) {
      System.err.println("ОШИБКА: Файл свойств отсуствует!");
    }
  }

  public String getProperties(String key) {
    return property.getProperty(key);
  }
}
