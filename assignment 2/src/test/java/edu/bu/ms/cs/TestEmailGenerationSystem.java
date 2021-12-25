package edu.bu.ms.cs;

import static org.junit.Assert.assertEquals;

import edu.bu.ms.cs.customers.BusinessCustomer;
import edu.bu.ms.cs.customers.Customer;
import edu.bu.ms.cs.customers.FrequentCustomer;
import edu.bu.ms.cs.customers.NewCustomer;
import edu.bu.ms.cs.customers.ReturningCustomer;
import edu.bu.ms.cs.customers.VipCustomer;
import edu.bu.ms.cs.decorator.CheckSpellingGrammar;
import edu.bu.ms.cs.decorator.Encrypt;
import edu.bu.ms.cs.factory.ConcreteEmailGenerationSystem;
import edu.bu.ms.cs.factory.EmailGenerationSystem;
import edu.bu.ms.cs.factory.emails.Email;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Run tests in order of method names - ascending.
public class TestEmailGenerationSystem {
  private static final Logger logger = Logger.getLogger(TestEmailGenerationSystem.class);
  private static final String[] emailClasses =
      {"BusinessEmail", "FrequentEmail", "NewEmail", "ReturningEmail", "VipEmail"};
  private static final ArrayList<Customer> customers = new ArrayList<>();
  private EmailGenerationSystem eMailGenerationSystem;

  @BeforeClass
  public static void setupOnce() {
    // Runs once before all other tests.
    // Adds customers to ArrayList customers.
    customers.add(new BusinessCustomer("business customer"));
    customers.add(new FrequentCustomer("frequent customer"));
    customers.add(new NewCustomer("new customer"));
    customers.add(new ReturningCustomer("returning customer"));
    customers.add(new VipCustomer("vip customer"));
  }

  @Before
  public void setup() {
    // Runs before each test.
    // Creates once singleton and factory eMailGenerationSystem.
    eMailGenerationSystem =
        ConcreteEmailGenerationSystem.createConcreteEmailGenerationSystemSingleton();
  }

  @Test
  public void test1CreateEmail() {
    // Creates for each customer type in ArrayList customers a corresponding email of correct type
    // with eMailGenerationSystem factory.
    Email email;
    for (int index = 0; index < customers.size(); index++) {
      email = eMailGenerationSystem.createEmail(customers.get(index));
      // And asserts whether created Email object is of correct type.
      assertEquals(emailClasses[index], email.getClass().getSimpleName());
    }
  }

  @Test
  public void test2CheckSpellingGrammar() {
    // Logs newline - for a clearer log.
    logger.info("");
    // Creates a businessEmail with eMailGenerationSystem factory.
    Email businessEmail =
        eMailGenerationSystem.createEmail(new BusinessCustomer("business customer"));
    // Adds spell and grammar check - concrete decorator.
    businessEmail = new CheckSpellingGrammar(businessEmail);
    // Asserts whether decorator was added.
    String decoratedEmail = businessEmail.getEmail();
    logger.info("Decorated email: " + decoratedEmail);
    assertEquals(
        "Email{customerName='business customer', header='Header BusinessEmail', "
            + "text='Text BusinessEmail', footer='Footer BusinessEmail'} - component unique to "
            + "BusinessEmail - Checked spelling and grammar!",
        decoratedEmail);
  }

  @Test
  public void test3Encrypt() {
    // Logs newline - for a clearer log.
    logger.info("");
    // Creates a frequentEmail with eMailGenerationSystem factory.
    Email businessEmail =
        eMailGenerationSystem.createEmail(new FrequentCustomer("frequent customer"));
    // Adds encryption - concrete decorator.
    businessEmail = new Encrypt(businessEmail);
    // Asserts whether decorator was added.
    String decoratedEmail = businessEmail.getEmail();
    logger.info("Decorated email: " + decoratedEmail);
    assertEquals(
        "Email{customerName='frequent customer', header='Header FrequentEmail', "
            + "text='Text FrequentEmail', footer='Footer FrequentEmail'} - component unique to "
            + "FrequentEmail - Encrypted email!",
        decoratedEmail);
  }

  @Test
  public void test4CheckSpellingGrammarEncrypt() {
    // Logs newline - for a clearer log.
    logger.info("");
    // Creates a newEmail with eMailGenerationSystem factory.
    Email businessEmail =
        eMailGenerationSystem.createEmail(new NewCustomer("new customer"));
    // Adds spell and grammar check - concrete decorator.
    businessEmail = new CheckSpellingGrammar(businessEmail);
    // Adds encryption - concrete decorator.
    businessEmail = new Encrypt(businessEmail);
    // Asserts whether decorators were added.
    String decoratedEmail = businessEmail.getEmail();
    logger.info("Decorated email: " + decoratedEmail);
    assertEquals(
        "Email{customerName='new customer', header='Header NewEmail', "
            + "text='Text NewEmail', footer='Footer NewEmail'} - component unique to "
            + "NewEmail - Checked spelling and grammar! - Encrypted email!",
        decoratedEmail);
  }
}
