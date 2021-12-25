package edu.bu.ms.cs.adapter;

import edu.bu.ms.cs.Customer;

// Old data management system.
public interface CustomerDataOld {
  Customer getCustomer(String email);
}
