package edu.bu.ms.cs.memento;

import edu.bu.ms.cs.builder.DenseNeuralNetwork;
import org.apache.log4j.Logger;

// Originator (memento pattern) and singleton (singleton pattern).
public class ConcreteOriginator implements Originator {
  private static final Logger logger = Logger.getLogger(ConcreteOriginator.class);

  // Necessary for singleton.
  private static ConcreteOriginator concreteOriginator;

  // Necessary for originator.
  private DenseNeuralNetwork denseNeuralNetwork;

  /**
   * private constructor to enable singleton use - originator can only be instantiated once by
   * calling createOriginatorSingleton method.
   */
  private ConcreteOriginator() {
    logger.info("Originator created as singleton");
  }

  /**
   * Instantiates a ConcreteOriginator object once - as a singleton.
   *
   * @return instance of ConcreteOriginator as singleton.
   */
  public static ConcreteOriginator createOriginatorSingleton() {
    // If true: concreteOriginator has not yet been instantiated, instantiates concreteOriginator.
    if (concreteOriginator == null) {
      concreteOriginator = new ConcreteOriginator();
    }
    return concreteOriginator;
  }

  /**
   * Gets dense neural network.
   *
   * @return denseNeuralNetwork as DenseNeuralNetwork.
   */
  public DenseNeuralNetwork getCurrentDenseNeuralNetwork() {
    return denseNeuralNetwork;
  }

  /**
   * Sets dense neural network.
   *
   * @param denseNeuralNetwork as DenseNeuralNetwork.
   */
  public void setDenseNeuralNetwork(DenseNeuralNetwork denseNeuralNetwork) {
    this.denseNeuralNetwork = denseNeuralNetwork;
  }

  /**
   * Saves dense neural network in a Memento object.
   *
   * @return memento - containing dense neural network - as Memento.
   */
  @Override
  public Memento saveDenseNeuralNetwork() {
    return new Memento(denseNeuralNetwork);
  }

  /**
   * Loads dense neural network from a Memento.
   *
   * @param savedMemento - containing dense neural network - as Memento.
   */
  @Override
  public void loadDenseNeuralNetwork(Memento savedMemento) {
    denseNeuralNetwork = savedMemento.getDenseNeuralNetwork();
  }

  /**
   * Fits dense neural network.
   *
   * @return fitted dense neural network as DenseNeuralNetwork.
   */
  public DenseNeuralNetwork fitModel() {
    return denseNeuralNetwork.fit();
  }

  // Memento (memento pattern).
  // Memento as inner class in ConcreteOriginator - and all methods are private so that only
  // ConcreteOriginator as outer class and Memento as inner class have access to Memento.
  public static class Memento {
    private final DenseNeuralNetwork denseNeuralNetwork;

    /**
     * Constructor sets memento's attribute.
     *
     * @param denseNeuralNetwork as DenseNeuralNetwork.
     */
    private Memento(DenseNeuralNetwork denseNeuralNetwork) {
      this.denseNeuralNetwork = denseNeuralNetwork;
    }

    /**
     * Gets dense neural network from Memento.
     *
     * @return denseNeuralNetwork as DenseNeuralNetwork.
     */
    private DenseNeuralNetwork getDenseNeuralNetwork() {
      return denseNeuralNetwork;
    }
  }
}