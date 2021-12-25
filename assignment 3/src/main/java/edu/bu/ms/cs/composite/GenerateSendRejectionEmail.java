package edu.bu.ms.cs.composite;

import edu.bu.ms.cs.Customer;
import org.apache.log4j.Logger;

// Leaf.
public class GenerateSendRejectionEmail implements DataProcess {
  private static final Logger logger = Logger.getLogger(GenerateSendRejectionEmail.class);
  private final Customer customer;

  /**
   * Constructor sets Customer object.
   *
   * @param customer which contains customer data as Customer.
   */
  public GenerateSendRejectionEmail(Customer customer) {
    this.customer = customer;
    logger.info("Generation and send of rejection email has been created.");
  }

  /**
   * Generates and sends rejection email.
   *
   * @return true if creating and sending was successful as boolean.
   */
  @Override
  public boolean processData() {
    // Generates and sends rejection email.
    logger.info("Generation and send of rejection email has been completed.");
    return true;
  }
}
