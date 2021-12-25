package edu.bu.ms.cs;

import java.util.ArrayList;
import org.apache.log4j.Logger;

// Observable.
public class ConcreteShop implements Shop {
  private static final Logger logger = Logger.getLogger(ConcreteShop.class);
  private final ArrayList<Driver> drivers = new ArrayList<>(); // Will hold all registered drivers.
  private DeliveryRequest deliveryRequest; // Will be send via notifyDrivers method.

  /**
   * Registers driver, adds them to ArrayList.
   *
   * @param driver is a driver (observer) as Driver.
   */
  @Override
  public void registerDriver(Driver driver) {
    // Adds driver to ArrayList<Driver>.
    drivers.add(driver);
    logger.info("Shop - registered driver: " + ((ConcreteDriver) driver).getName());
  }

  /**
   * Removes driver, removes them from ArrayList.
   *
   * @param driver is a driver (observer) as Driver.
   */
  @Override
  public void removeDriver(Driver driver) {
    // Removes driver from ArrayList<Driver>.
    drivers.remove(driver);
  }

  /**
   * Shop informs driver(s) after delivery request was set that it has new delivery request.
   *
   * @param deliveryRequest is a delivery request as DeliveryRequest.
   */
  @Override
  public void notifyDrivers(DeliveryRequest deliveryRequest) {
    // Sets deliveryRequest in ConcreteShop.
    this.deliveryRequest = deliveryRequest;
    // Iterates over all drivers & informs them of delivery request by calling their update method.
    for (Driver driver : drivers) {
      driver.update(deliveryRequest);
    }
    logger.info("Shop - sends delivery request:");
    logger.info(deliveryRequest);
  }

  /**
   * Gets delivery request (state).
   *
   * @return deliveryRequest as DeliveryRequest.
   */
  public DeliveryRequest getDeliveryRequest() {
    return deliveryRequest;
  }

  /**
   * Gets all drivers.
   *
   * @return drivers as ArrayList.
   */
  public ArrayList<Driver> getDrivers() {
    return drivers;
  }
}