package edu.bu.ms.cs.composite;

import edu.bu.ms.cs.Customer;
import org.apache.log4j.Logger;

// Leaf.
public class EmailAddressVerification implements DataProcess {
  private static final Logger logger = Logger.getLogger(EmailAddressVerification.class);
  private final Customer customer;

  /**
   * Constructor sets Customer object.
   *
   * @param customer which contains customer data as Customer.
   */
  public EmailAddressVerification(Customer customer) {
    this.customer = customer;
    logger.info("Email address verification has been created.");
  }

  /**
   * Does email address verification.
   *
   * @return true if email address verification was successful as boolean.
   */
  @Override
  public boolean processData() {
    // Does email address verification.
    logger.info("Email address verification has been completed.");
    return true;
  }
}