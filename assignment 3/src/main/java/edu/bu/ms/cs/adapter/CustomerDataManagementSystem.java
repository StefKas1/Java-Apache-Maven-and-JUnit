package edu.bu.ms.cs.adapter;

import edu.bu.ms.cs.Customer;

// New data management system.
public interface CustomerDataManagementSystem {
  Customer getCustomer(String email, String phoneNumber);
}
