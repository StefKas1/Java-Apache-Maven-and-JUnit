package edu.bu.ms.cs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import edu.bu.ms.cs.adapter.ConcreteCustomerDataManagementSystem;
import edu.bu.ms.cs.adapter.ConcreteCustomerDataOld;
import edu.bu.ms.cs.adapter.CustomerDataOldAdapter;
import edu.bu.ms.cs.composite.BackgroundCheck;
import edu.bu.ms.cs.composite.Composite;
import edu.bu.ms.cs.composite.DataProcess;
import edu.bu.ms.cs.composite.EmailAddressVerification;
import edu.bu.ms.cs.composite.GenerateSendRejectionEmail;
import edu.bu.ms.cs.composite.GenerateSendWelcomeEmail;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Run tests in order of method names - ascending.
public class TestConcrete {
  private static final Logger logger = Logger.getLogger(TestConcrete.class);
  private static final ConcreteCustomerDataOld concreteCustomerDataOld =
      new ConcreteCustomerDataOld();
  private static final String[] dataProcessingCategories =
      {"EmailAddressVerification", "BackgroundCheck", "GenerateSendWelcomeEmail",
          "GenerateSendRejectionEmail"};
  private static ConcreteCustomerDataManagementSystem concreteCustomerDataManagementSystem;
  private static Composite composite;

  @BeforeClass
  public static void setup() {
    // Runs once before all other tests.
    // Creates customers and adds customers to database.
    logger.info("\n--- Creates customers and adds customers to database ---");
    concreteCustomerDataOld
        .setCustomer(new Customer("Name A", "Street and City A", "A@a.com", "000000"));
    concreteCustomerDataOld
        .setCustomer(new Customer("Name B", "Street and City B", "B@b.com", "111111"));
    concreteCustomerDataOld
        .setCustomer(new Customer("Name C", "Street and City C", "C@c.com", "222222"));

    // Passes CustomerDataOldAdapter object to parameterized constructor, so that client(s) can use
    // old interface CustomerDataOld to access customer data.
    concreteCustomerDataManagementSystem =
        new ConcreteCustomerDataManagementSystem(new CustomerDataOldAdapter());
  }

  @Test
  public void test1ConcreteCustomerDataManagementSystem() {
    logger.info("\n--- Obtains customer data via new system using adapter and old API ---");
    // Calls method getCustomer(String, String) of new system; in this method, method
    // getCustomer(String, String) of the CustomerDataOldAdapter is called, which in turn calls the
    // method getCustomer(String) of ConcreteCustomerDataOld.
    // Gets two customers from database via adapter and asserts whether API call works (uses
    // adapter).
    assertEquals("A@a.com",
        concreteCustomerDataManagementSystem.getCustomer("A@a.com", "000000").getEmail());
    assertEquals("B@b.com",
        concreteCustomerDataManagementSystem.getCustomer("B@b.com", "111111").getEmail());
    logger.info("Adapter works!"); // Is only reached if asserts are successful.
  }

  @Test
  public void test2Add() {
    logger.info(
        "\n--- Creates components for data processing and adds them to composite; "
            + "first gets customer ---\n"
            + "Note, the components are only added to the composite, they are not executed yet.");
    Customer customer = concreteCustomerDataManagementSystem.getCustomer("B@b.com", "111111");

    // Composite.
    // Creates components for data processing.
    DataProcess emailAddressVerification = new EmailAddressVerification(customer);
    DataProcess backgroundCheck = new BackgroundCheck(customer);
    DataProcess generateSendWelcomeEmail = new GenerateSendWelcomeEmail(customer);
    DataProcess generateSendRejectionEmail = new GenerateSendRejectionEmail(customer);

    // Creates composite to add and remove data processing components - note, here it only adds, it
    // does not run the components yet.
    composite = new Composite();
    composite.add(emailAddressVerification);
    composite.add(backgroundCheck);
    composite.add(generateSendWelcomeEmail);
    composite.add(generateSendRejectionEmail); // Added by mistake.

    // Gets ArrayList concreteDataProcesses and asserts whether data processing component object is
    // of correct type.
    ArrayList<DataProcess> concreteDataProcesses = composite.getConcreteDataProcesses();
    DataProcess concreteDataProcess;
    for (int index = 0; index < concreteDataProcesses.size(); index++) {
      concreteDataProcess = concreteDataProcesses.get(index);
      // Asserts whether data processing component object is of correct type.
      assertEquals(dataProcessingCategories[index], concreteDataProcess.getClass().getSimpleName());
    }
  }

  @Test
  public void test3Remove() {
    logger.info("\n--- Removes added generateSendRejectionEmail component from composite ---");
    // Removes by mistake added generateSendRejectionEmail.
    // First gets the object from the ArrayList to then assert whether the correct object has been
    // removed with the fetched object.
    ArrayList<DataProcess> concreteDataProcesses = composite.getConcreteDataProcesses();
    DataProcess processToBeRemoved = concreteDataProcesses.get(3);
    composite.remove(processToBeRemoved);
    // Asserts whether correct data processing component was removed.
    for (DataProcess dataProcess : concreteDataProcesses) {
      assertNotEquals(processToBeRemoved, dataProcess);
    }
    // Is only reached if asserts are successful.
    logger.info(
        "Removal of " + processToBeRemoved.getClass().getSimpleName() + " was successful!");
  }

  @Test
  public void test4ProcessData() {
    logger.info("\n--- Runs data processing components ---");
    // Runs data processing components.
    assertTrue(composite.processData());
  }
}
