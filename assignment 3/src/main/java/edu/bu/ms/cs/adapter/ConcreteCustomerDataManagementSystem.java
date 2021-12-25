package edu.bu.ms.cs.adapter;

import edu.bu.ms.cs.Customer;
import org.apache.log4j.Logger;

// New concrete data management system.
public class ConcreteCustomerDataManagementSystem implements CustomerDataManagementSystem {
  private static final Logger logger = Logger.getLogger(ConcreteCustomerDataManagementSystem.class);
  private final CustomerDataManagementSystem customerDataManagementSystem;

  /**
   * Constructor sets concrete CustomerDataManagementSystem.
   *
   * @param customerDataManagementSystem as CustomerDataManagementSystem.
   */
  public ConcreteCustomerDataManagementSystem(
      CustomerDataManagementSystem customerDataManagementSystem) {
    this.customerDataManagementSystem = customerDataManagementSystem;
  }

  /**
   * Gets customer object.
   *
   * @param email       address of customer as String.
   * @param phoneNumber of customer as String.
   * @return customer which contains customer data as Customer.
   */
  @Override
  public Customer getCustomer(String email, String phoneNumber) {
    // For a customerDataManagementSystem object of type CustomerDataOldAdapter: will call
    // getCustomer() method in CustomerDataOldAdapter.
    logger.info(
        "Method getCustomer (in new system) was called with arguments: " + email + " | "
            + phoneNumber);
    return customerDataManagementSystem.getCustomer(email, phoneNumber);
  }
}
