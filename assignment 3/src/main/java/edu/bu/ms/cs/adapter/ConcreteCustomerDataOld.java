package edu.bu.ms.cs.adapter;

import edu.bu.ms.cs.Customer;
import java.util.HashMap;
import org.apache.log4j.Logger;

// Old concrete data management system.
public class ConcreteCustomerDataOld implements CustomerDataOld {
  private static final Logger logger = Logger.getLogger(ConcreteCustomerDataOld.class);
  private static final HashMap<String, Customer> customerDatabase = new HashMap<>();

  /**
   * Gets customer object from database.
   *
   * @param email address as String.
   * @return customer which contains customer data as Customer.
   */
  @Override
  public Customer getCustomer(String email) {
    logger.info("Method getCustomer (in old system) was called with argument: " + email);
    return customerDatabase.get(email); // Returns null if key (email) is not in database.
  }

  /**
   * Puts customer in database if customer is not already in database.
   *
   * @param customer which contains customer data as Customer.
   */
  public void setCustomer(Customer customer) {
    // If customer is not already in the database, put customer in database (else do nothing).
    if (!customerDatabase.containsKey(customer.getEmail())) {
      customerDatabase.put(customer.getEmail(), customer);
      logger.info("Customer was added to database: " + customer);
    }
  }
}
