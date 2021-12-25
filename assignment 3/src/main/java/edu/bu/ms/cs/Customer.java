package edu.bu.ms.cs;

public class Customer {
  private final String name;
  private final String address;
  private final String email;
  private final String phoneNumber;

  /**
   * Constructor sets customer information.
   *
   * @param name        of customer as String.
   * @param address     of customer as String.
   * @param email       address of customer as String.
   * @param phoneNumber of customer as String.
   */
  public Customer(String name, String address, String email, String phoneNumber) {
    this.name = name;
    this.address = address;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  /**
   * Gets email address of customer.
   *
   * @return email address of customer as String.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Builds String which contains customer information.
   *
   * @return customer information as String.
   */
  @Override
  public String toString() {
    return "Customer{"
        + "name='" + name + '\''
        + ", address='" + address + '\''
        + ", email='" + email + '\''
        + ", phoneNumber='" + phoneNumber + '\''
        + '}';
  }
}