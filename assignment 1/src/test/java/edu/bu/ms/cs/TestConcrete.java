package edu.bu.ms.cs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Run tests in order of method names - ascending.
public class TestConcrete {
  private static final Logger logger = Logger.getLogger(TestConcrete.class);
  private static final ConcreteShop concreteShop = new ConcreteShop();
  private static final String[] driverNames = {"D1", "D2", "D3"};

  @BeforeClass
  public static void setup() {
    // Runs once before all other tests.
    // Instantiates drivers with names and registers drivers.
    logger.info("\n--- Shop: Register drivers ---");
    for (String driverName : driverNames) {
      concreteShop.registerDriver(new ConcreteDriver(driverName));
    }
  }

  @Test
  public void test1RegisterDriver() {
    // Gets all drivers.
    ArrayList<Driver> drivers = concreteShop.getDrivers();
    // Iterates over all drivers and asserts whether drivers were correctly registered.
    for (int index = 0; index < drivers.size(); index++) {
      assertEquals(((ConcreteDriver) drivers.get(index)).getName(), driverNames[index]);
    }
  }

  @Test
  public void test2GetDeliveryRequest() {
    logger.info("\n--- Drivers: Delivery request that the drivers know about ---");
    // Iterates over all drivers, asserts and logs whether delivery request is null.
    for (Driver driver : concreteShop.getDrivers()) {
      assertNull(((ConcreteDriver) driver).getDeliveryRequest());
      logger.info(((ConcreteDriver) driver).getName() + ": "
          + ((ConcreteDriver) driver).getDeliveryRequest()); // null.
    }
  }

  @Test
  public void test3NotifyDrivers() {
    logger.info("\n--- Shop: Create and send a delivery request ---");
    // Creates delivery request.
    DeliveryRequest deliveryRequest =
        new DeliveryRequest("Shop S1", "Customer C1", "Blue shirt", 1.99F);
    // Notifies all drivers about delivery request.
    concreteShop.notifyDrivers(deliveryRequest);

    logger.info("\n--- Drivers: Received delivery request ---");
    // Iterates over all drivers, asserts and logs whether delivery request was received.
    for (Driver driver : concreteShop.getDrivers()) {
      assertEquals(((ConcreteDriver) driver).getDeliveryRequest().toString(),
          deliveryRequest.toString());
      logger.info(((ConcreteDriver) driver).getName() + ": "
          + ((ConcreteDriver) driver).getDeliveryRequest()); // not null.
    }
  }

  @Test
  public void test4NotifyDrivers() {
    logger.info("\n--- Driver D1 accepts delivery request ---");
    // Driver 0 (D1) picks up the delivery - all drivers must be notified.
    ((ConcreteDriver) concreteShop.getDrivers().get(0)).acceptDeliveryRequest();
    logger.info("\n--- Shop: Informs all drivers that delivery request no longer exists ---");
    // Notifies all drivers that delivery request was accepted and no longer exists: null.
    concreteShop.notifyDrivers(null);

    logger.info("\n--- Drivers: Received delivery request ---");
    // Iterates over all drivers, asserts and logs whether delivery request is null.
    for (Driver driver : concreteShop.getDrivers()) {
      assertNull(((ConcreteDriver) driver).getDeliveryRequest());
      logger.info(((ConcreteDriver) driver).getName() + ": "
          + ((ConcreteDriver) driver).getDeliveryRequest()); // null.
    }
  }
}
