package edu.bu.ms.cs.composite;

import java.util.ArrayList;

public class Composite implements DataProcess {
  // Can hold leaves, concrete components: BackgroundCheck, EmailAddressVerification, ...
  private final ArrayList<DataProcess> concreteDataProcesses = new ArrayList<>();

  /**
   * Adds a concrete component (leaf) to concreteDataProcesses.
   *
   * @param process concrete component as DataProcess.
   */
  public void add(DataProcess process) {
    concreteDataProcesses.add(process);
  }

  /**
   * Removes a concrete component (leaf) from concreteDataProcesses.
   *
   * @param process concrete component as DataProcess.
   */
  public void remove(DataProcess process) {
    concreteDataProcesses.remove(process);
  }

  /**
   * Gets ArrayList of concrete components.
   *
   * @return ArrayList of data processing components.
   */
  public ArrayList<DataProcess> getConcreteDataProcesses() {
    return concreteDataProcesses;
  }

  /**
   * Does data processing by delegating dataProcessing to subclasses (concrete components, leaves).
   *
   * @return true if data processing was successful as boolean.
   */
  @Override
  public boolean processData() {
    // Iterates over all added data processes.
    for (DataProcess dataProcess : concreteDataProcesses) {
      dataProcess.processData();
    }
    // Returns status after data processing.
    return true;
  }

}
