package edu.bu.ms.cs;

import org.apache.log4j.Logger;

// Observer.
public class ConcreteDriver implements Driver {
  private static final Logger logger = Logger.getLogger(ConcreteDriver.class);
  private final String name; // Name of driver.
  private DeliveryRequest deliveryRequest; // Received delivery request.
  private DeliveryRequest acceptedDeliveryRequest; // Accepted delivery request.

  /**
   * Constructor sets driver's name.
   *
   * @param name of driver as String.
   */
  public ConcreteDriver(String name) {
    this.name = name;
  }

  /**
   * Informs all drivers (observers) about new delivery requests (state).
   *
   * @param deliveryRequest contains information about delivery request as DeliveryRequest.
   */
  @Override
  public void update(DeliveryRequest deliveryRequest) {
    this.deliveryRequest = deliveryRequest;
  }

  /**
   * Sets accepted delivery request.
   */
  public void acceptDeliveryRequest() {
    acceptedDeliveryRequest = deliveryRequest;
    logger.info("Driver " + name + " was first to accept delivery request: " + deliveryRequest);
  }

  /**
   * Gets delivery request.
   *
   * @return delivery request as DeliveryRequest.
   */
  public DeliveryRequest getDeliveryRequest() {
    return deliveryRequest;
  }

  /**
   * Gets name of driver.
   *
   * @return name of driver as String.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets accepted delivery request.
   *
   * @return accepted delivery request as DeliveryRequest.
   */
  public DeliveryRequest getAcceptedDeliveryRequest() {
    return acceptedDeliveryRequest;
  }
}
