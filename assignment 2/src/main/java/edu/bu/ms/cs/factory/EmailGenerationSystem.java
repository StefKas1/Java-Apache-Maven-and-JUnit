package edu.bu.ms.cs.factory;

import edu.bu.ms.cs.customers.Customer;
import edu.bu.ms.cs.factory.emails.Email;

public interface EmailGenerationSystem {
  Email createEmail(Customer customer);
}
