package edu.bu.ms.cs.decorator;

import edu.bu.ms.cs.factory.emails.Email;
import org.apache.log4j.Logger;

// Concrete decorator.
public class CheckSpellingGrammar extends EmailDecorator {
  private static final Logger logger = Logger.getLogger(CheckSpellingGrammar.class);
  private final Email email; // Necessary for decorator.

  /**
   * Constructor sets Email object.
   *
   * @param email as Email.
   */
  public CheckSpellingGrammar(Email email) {
    this.email = email;
  }

  /**
   * Decorates email object by adding spelling and grammar check.
   *
   * @return decorated email as String.
   */
  @Override
  public String getEmail() {
    logger.info("Decorator: spelling and grammar are checked.");
    return email.getEmail() + " - Checked spelling and grammar!";
  }
}
