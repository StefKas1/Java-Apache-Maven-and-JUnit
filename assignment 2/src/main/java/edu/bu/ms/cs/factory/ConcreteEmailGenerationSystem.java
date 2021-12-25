package edu.bu.ms.cs.factory;

import edu.bu.ms.cs.customers.Customer;
import edu.bu.ms.cs.factory.emails.BusinessEmail;
import edu.bu.ms.cs.factory.emails.Email;
import edu.bu.ms.cs.factory.emails.FrequentEmail;
import edu.bu.ms.cs.factory.emails.NewEmail;
import edu.bu.ms.cs.factory.emails.ReturningEmail;
import edu.bu.ms.cs.factory.emails.VipEmail;
import org.apache.log4j.Logger;

// Factory implemented as singleton.
public class ConcreteEmailGenerationSystem implements EmailGenerationSystem {
  private static final Logger logger = Logger.getLogger(ConcreteEmailGenerationSystem.class);
  // Necessary for singleton.
  private static ConcreteEmailGenerationSystem concreteEMailGenerationSystem;

  /**
   * private constructor to enable singleton use - concreteEMailGenerationSystem can only be
   * instantiated once by calling createConcreteEMailGenerationSystem method.
   */
  private ConcreteEmailGenerationSystem() {
    logger.info("EMailGenerationSystem created as singleton.");
  }

  /**
   * Instantiates a ConcreteEMailGenerationSystem object once - as a singleton.
   *
   * @return instance of ConcreteEMailGenerationSystem as singleton.
   */
  public static ConcreteEmailGenerationSystem createConcreteEmailGenerationSystemSingleton() {
    // If true: concreteEMailGenerationSystem has not yet been instantiated, instantiates
    // concreteEMailGenerationSystem.
    if (concreteEMailGenerationSystem == null) {
      concreteEMailGenerationSystem = new ConcreteEmailGenerationSystem();
    }
    return concreteEMailGenerationSystem;
  }

  /**
   * Depending on customer type, factory method creates email of correct type.
   *
   * @param customer containing information about customer as Customer.
   * @return email as Email.
   */
  @Override
  public Email createEmail(Customer customer) { // Factory method.
    Email email = null;
    // Gets (simple) class name as String and runs matching case.
    switch (customer.getClass().getSimpleName()) {
      case "BusinessCustomer":
        // When BusinessEmail is created, customer object is passed to parameterized constructor;
        // customer object contains information about customer, which are inserted into email.
        email = new BusinessEmail(customer);
        logger.info("BusinessEmail was created.");
        break;
      case "FrequentCustomer":
        email = new FrequentEmail(customer);
        logger.info("FrequentEmail was created.");
        break;
      case "NewCustomer":
        email = new NewEmail(customer);
        logger.info("NewEmail was created.");
        break;
      case "ReturningCustomer":
        email = new ReturningEmail(customer);
        logger.info("ReturningEmail was created.");
        break;
      case "VipCustomer":
        email = new VipEmail(customer);
        logger.info("VipEmail was created.");
        break;
      default:
        // Logs that customer object is unknown.
        logger.info("Customer type is unknown, no email created.");
        break;
    }
    return email;
  }
}
