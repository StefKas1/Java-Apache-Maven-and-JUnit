package edu.bu.ms.cs.memento;

import edu.bu.ms.cs.builder.DenseNeuralNetwork;
import edu.bu.ms.cs.memento.ConcreteOriginator.Memento;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.log4j.Logger;

// Caretaker (memento pattern) and singleton (singleton pattern).
public class ConcreteCaretaker implements Caretaker {
  private static final Logger logger = Logger.getLogger(ConcreteCaretaker.class);

  // Necessary for singleton.
  private static ConcreteCaretaker concreteCaretaker;

  // Necessary for caretaker.
  private final ConcreteOriginator concreteOriginator;
  // Caretaker will hold Memento objects created by the Originator object, so Caretaker object can
  // make Originator object restore a DenseNeuralNetwork object from a Memento object when needed.
  // Note, a Memento objects contains a saved DenseNeuralNetwork object.
  private final LinkedHashMap<Integer, Memento> mementos = new LinkedHashMap<>();
  private int saveKey = 0;

  /**
   * private constructor to enable singleton use - concreteCaretaker can only be instantiated once
   * by calling createCaretakerSingleton method.
   *
   * @param concreteOriginator handle to concrete originator as ConcreteOriginator.
   */
  private ConcreteCaretaker(ConcreteOriginator concreteOriginator) {
    logger.info("Caretaker created as singleton");
    this.concreteOriginator = concreteOriginator;
  }

  /**
   * Instantiates a ConcreteCaretaker object once - as a singleton.
   *
   * @param concreteOriginator handle to concrete originator as ConcreteOriginator.
   * @return instance of ConcreteCaretaker as singleton.
   */
  public static ConcreteCaretaker createCaretakerSingleton(ConcreteOriginator concreteOriginator) {
    // If true: concreteCaretaker has not yet been instantiated, instantiates concreteCaretaker.
    if (concreteCaretaker == null) {
      concreteCaretaker = new ConcreteCaretaker(concreteOriginator);
    }
    return concreteCaretaker;
  }

  /**
   * Caretaker object makes Originator object get dense neural network (DNN) from Originator object.
   *
   * @return denseNeuralNetwork as DenseNeuralNetwork.
   */
  public DenseNeuralNetwork getDnn() {
    return concreteOriginator.getCurrentDenseNeuralNetwork();
  }

  /**
   * Caretaker object makes Originator object put dense neural network (DNN) into Originator object.
   *
   * @param denseNeuralNetwork as DenseNeuralNetwork.
   */
  public void setDnn(DenseNeuralNetwork denseNeuralNetwork) {
    concreteOriginator.setDenseNeuralNetwork(denseNeuralNetwork);
  }

  /**
   * Caretaker object makes Originator object save dense neural network, which was put into
   * Originator object, into a Memento object. And Caretaker object puts created Memento object into
   * LinkedHashMap mementos.
   */
  @Override
  public void callSaveDenseNeuralNetwork() {
    // saveKey is key to access memento in LinkedHashMap mementos; and value is Memento object
    // created by Originator object.
    mementos.put(++saveKey, concreteOriginator.saveDenseNeuralNetwork());
    logger.info("Memento saved, the key is: " + saveKey);
  }

  /**
   * Caretaker object passes a Memento object to Originator object and Caretaker object makes
   * Originator object load/get dense neural network from Memento object and makes Originator object
   * put this dense neural network into Originator object.
   *
   * @param key is LinkedHashMap key as int.
   */
  @Override
  public void callLoadDenseNeuralNetwork(int key) {
    // If key does not exist in LinkedHashMap, log that - and log existing keys.
    if (key < 1 || key > mementos.size()) {
      logger.info("Key \"" + key + "\" does not exist");
      logger.info("Available keys are: " + mementos.keySet());
    } else {
      // Else: get memento from LinkedHashMap, log, and pass to Originator.
      Memento memento = mementos.get(key); // Gets memento.
      concreteOriginator.loadDenseNeuralNetwork(memento); // Pass memento and set DNN in Originator.
      // Logs.
      logger.info("Load | key: " + key + " | " + concreteOriginator.getCurrentDenseNeuralNetwork());
    }
  }

  /**
   * Logs all saved neural networks.
   */
  public void printSavedDenseNeuralNetworks() {
    // Iterates over entire LinkedHashMap and logs keys and values.
    for (Map.Entry<Integer, Memento> item : mementos.entrySet()) {
      concreteOriginator
          .loadDenseNeuralNetwork(item.getValue()); // Pass memento and set DNN in Originator.
      // Logs.
      logger.info(
          "Key: " + item.getKey() + " | " + concreteOriginator.getCurrentDenseNeuralNetwork());
    }
  }

  /**
   * Gets LinkedHashMap which contains Memento.
   *
   * @return mementos as LinkedHasMap.
   */
  public LinkedHashMap<Integer, Memento> getMementos() {
    return mementos;
  }
}
