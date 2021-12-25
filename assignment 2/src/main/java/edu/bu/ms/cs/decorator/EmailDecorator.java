package edu.bu.ms.cs.decorator;

import edu.bu.ms.cs.factory.emails.Email;

public abstract class EmailDecorator extends Email {
  // Necessary for decorator.
  public abstract String getEmail();
}
