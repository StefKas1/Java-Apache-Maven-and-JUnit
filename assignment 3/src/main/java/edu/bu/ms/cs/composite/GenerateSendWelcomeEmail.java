package edu.bu.ms.cs.composite;

import edu.bu.ms.cs.Customer;
import org.apache.log4j.Logger;

// Leaf.
public class GenerateSendWelcomeEmail implements DataProcess {
  private static final Logger logger = Logger.getLogger(GenerateSendWelcomeEmail.class);
  private final Customer customer;

  /**
   * Constructor sets Customer object.
   *
   * @param customer which contains customer data as Customer.
   */
  public GenerateSendWelcomeEmail(Customer customer) {
    this.customer = customer;
    logger.info("Generation and send of welcome email has been created.");
  }

  /**
   * Generates and sends welcome email.
   *
   * @return true if creating and sending was successful as boolean.
   */
  @Override
  public boolean processData() {
    // Generates and sends welcome email.
    logger.info("Generation and send of welcome email has been completed.");
    return true;
  }
}