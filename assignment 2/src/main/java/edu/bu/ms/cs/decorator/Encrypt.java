package edu.bu.ms.cs.decorator;

import edu.bu.ms.cs.factory.emails.Email;
import org.apache.log4j.Logger;

// Concrete decorator.
public class Encrypt extends EmailDecorator {
  private static final Logger logger = Logger.getLogger(Encrypt.class);
  private final Email email; // Necessary for decorator.

  /**
   * Constructor sets Email object.
   *
   * @param email as Email.
   */
  public Encrypt(Email email) {
    this.email = email;
  }

  /**
   * Decorates email object by adding encryption.
   *
   * @return decorated email as String.
   */
  @Override
  public String getEmail() {
    logger.info("Decorator: email is encrypted.");
    return email.getEmail() + " - Encrypted email!";
  }
}
