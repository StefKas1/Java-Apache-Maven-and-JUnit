package edu.bu.ms.cs.adapter;

import edu.bu.ms.cs.Customer;
import org.apache.log4j.Logger;

// Adapter.
public class CustomerDataOldAdapter implements CustomerDataManagementSystem {
  private static final Logger logger = Logger.getLogger(CustomerDataOldAdapter.class);
  private final ConcreteCustomerDataOld concreteCustomerDataOld;

  /**
   * Constructor sets concreteCustomerDataOld.
   */
  public CustomerDataOldAdapter() {
    concreteCustomerDataOld = new ConcreteCustomerDataOld();
  }

  /**
   * Gets customer via concreteCustomerDataOld system from database.
   *
   * @param email       address of customer as String.
   * @param phoneNumber of customer as String.
   * @return customer which contains customer data as Customer.
   */
  @Override
  public Customer getCustomer(String email, String phoneNumber) {
    // Calls  getCustomer() method in ConcreteCustomerDataOld.
    logger.info("Method getCustomer (in adapter) was called with arguments: " + email + " | "
        + phoneNumber);
    return concreteCustomerDataOld.getCustomer(email);
  }
}
