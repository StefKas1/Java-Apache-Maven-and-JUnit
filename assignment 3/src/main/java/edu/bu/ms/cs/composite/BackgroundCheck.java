package edu.bu.ms.cs.composite;

import edu.bu.ms.cs.Customer;
import org.apache.log4j.Logger;

// Leaf.
public class BackgroundCheck implements DataProcess {
  private static final Logger logger = Logger.getLogger(BackgroundCheck.class);
  private final Customer customer;

  /**
   * Constructor sets Customer object.
   *
   * @param customer which contains customer data as Customer.
   */
  public BackgroundCheck(Customer customer) {
    this.customer = customer;
    logger.info("Background check has been created.");
  }

  /**
   * Does background check.
   *
   * @return true if background check was successful as boolean.
   */
  @Override
  public boolean processData() {
    // Does background check.
    logger.info("Background check has been completed.");
    return true;
  }
}
