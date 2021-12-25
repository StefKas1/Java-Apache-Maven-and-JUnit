package edu.bu.ms.cs;

public class DeliveryRequest {
  private final String from;
  private final String to;
  private final String product;
  private final float compensation;

  /**
   * Constructor sets delivery request's information.
   *
   * @param from         pick-up location of product as String.
   * @param to           delivery location of product as String.
   * @param product      as String.
   * @param compensation how much driver receives for delivery as float.
   */
  public DeliveryRequest(String from, String to, String product, float compensation) {
    this.from = from;
    this.to = to;
    this.product = product;
    this.compensation = compensation;
  }

  /**
   * Builds String which contains entire delivery request information.
   *
   * @return delivery request information as String.
   */
  @Override
  public String toString() {
    return "DeliveryRequest{from='" + from + "', to='" + to + "', product='" + product
        + "', compensation=$" + compensation + '}';
  }
}
