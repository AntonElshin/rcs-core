package ru.rcs;

import java.util.UUID;
import org.junit.jupiter.api.Test;

class RcsCoreServiceApplicationTests {

  @Test
  void generateUUID() {
    UUID uuid = UUID.randomUUID();
    String uuidAsString = uuid.toString();

    System.out.println("Your UUID is: " + uuidAsString);
  }

}
