package edu.bu.ms.cs;

import static org.junit.Assert.assertEquals;

import edu.bu.ms.cs.builder.BuildModel;
import edu.bu.ms.cs.builder.Layer;
import edu.bu.ms.cs.memento.ConcreteCaretaker;
import edu.bu.ms.cs.memento.ConcreteOriginator;
import edu.bu.ms.cs.memento.ConcreteOriginator.Memento;
import java.util.Map;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

// Used patterns: Memento; Singleton twice, and Builder.
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Runs tests in order of method names - ascending.
public class TestConcreteCaretaker {
  private static final Logger logger = Logger.getLogger(TestConcreteCaretaker.class);
  private static ConcreteOriginator concreteOriginator;
  private static ConcreteCaretaker concreteCaretaker;

  @BeforeClass
  public static void setup() {
    // Runs once before all other tests.
    // Instantiates concreteOriginator and concreteCaretaker.
    logger.info("\n--- Creates originator and caretaker as singletons ---");
    concreteOriginator = ConcreteOriginator.createOriginatorSingleton();
    concreteCaretaker = ConcreteCaretaker.createCaretakerSingleton(concreteOriginator);
  }

  @Test
  public void test1CallSaveDenseNeuralNetwork() {
    logger.info(
        "\n--- Builder builds new model, caretaker gives model to originator, and originator puts "
            + "model in Memento object ---");
    // Creates/builds a dense neural network that will not be saved: Sequential A.
    concreteCaretaker.setDnn(new BuildModel().addModelType("Sequential A").compile()); // Not saved.
    // Creates/builds a dense neural network that will be saved: Sequential B.
    // Builds dense neural network, and concreteCaretaker makes concreteOriginator hold dense neural
    // network in concreteOriginator.
    concreteCaretaker
        .setDnn(
            new BuildModel()
                .addModelType("Sequential B")
                .addLayer(new Layer("Dense", 12, "relu"))
                .addLayer(new Layer("Dense", 24, "tanh"))
                .addLossFunction("MeanAbsoluteError")
                .addOptimizer("adam")
                .addMetric("accuracy")
                .compile()); // Will be saved.
    logger.info("--- Saves last created model in Memento object ---");
    // concreteCaretaker makes concreteOriginator save dense neural network in a memento.
    concreteCaretaker.callSaveDenseNeuralNetwork();

    // Creates/builds a dense neural network that will be saved: Sequential C.
    // Builds dense neural network, and concreteCaretaker makes concreteOriginator hold dense neural
    // network in concreteOriginator.
    logger.info(
        "\n--- Builder builds new model, caretaker gives model to originator, and originator puts "
            + "model in Memento object ---");
    concreteCaretaker.setDnn(new BuildModel().addModelType("Sequential C").compile());
    logger.info("--- Saves last created model in Memento object ---");
    // concreteCaretaker makes concreteOriginator save dense neural network in a memento.
    concreteCaretaker.callSaveDenseNeuralNetwork();

    // Creates/builds a dense neural network that will be saved: Sequential D.
    // Builds dense neural network, and concreteCaretaker makes concreteOriginator hold dense neural
    // network in concreteOriginator.
    logger.info(
        "\n--- Builder builds new model, caretaker gives model to originator, and originator puts "
            + "model in Memento object ---");
    concreteCaretaker.setDnn(new BuildModel().addModelType("Sequential D").compile());
    logger.info("--- Saves last created model in Memento object ---");
    // concreteCaretaker makes concreteOriginator save dense neural network in a memento.
    concreteCaretaker.callSaveDenseNeuralNetwork();

    String[] modelTypes = {"Sequential B", "Sequential C", "Sequential D"};
    // Iterates over all mementos and asserts whether dense neural networks were saved in mementos.
    for (Map.Entry<Integer, Memento> item : concreteCaretaker.getMementos().entrySet()) {
      // Pass memento and set DNN in Originator.
      concreteOriginator.loadDenseNeuralNetwork(item.getValue());
      // -1 because item.getKey() starts from 1.
      assertEquals(modelTypes[item.getKey() - 1],
          concreteOriginator.getCurrentDenseNeuralNetwork().getModelType());
    }

    logger.info("\n--- Logs all saved models (mementos) ---");
    concreteCaretaker.printSavedDenseNeuralNetworks();
  }

  @Test
  public void test2GetDnn() {
    logger.info("\n--- Logs current model (memento)---");
    // Gets current dense neural network via concreteCaretaker from concreteOriginator.
    logger.info(concreteCaretaker.getDnn());
    // Asserts whether "Sequential D" is current dense neural network model type.
    assertEquals("Sequential D", concreteCaretaker.getDnn().getModelType());
  }

  @Test
  public void test3CallLoadDenseNeuralNetwork() {
    logger.info("\n--- Tries to load a nonexistent model (memento) with key 4 ---");
    concreteCaretaker.callLoadDenseNeuralNetwork(4); // Key 4 does not exist, can't be loaded.

    logger.info("\n--- Loads model with key 1 from Memento object & logs loaded model ---");
    // Caretaker object passes Memento object with key 1 to Originator object and Caretaker object
    // makes Originator object load/get dense neural network from Memento object and makes
    // Originator object put this dense neural network into Originator object.
    concreteCaretaker.callLoadDenseNeuralNetwork(1); // Key 1 exists, can be loaded.
    // Asserts whether "Sequential B" (key 1) is model type of loaded dense neural network.
    assertEquals("Sequential B", concreteCaretaker.getDnn().getModelType());
  }

  @Test
  public void test4FitModel() {
    logger.info("\n--- Fits loaded model ---");
    // Fits model.
    logger.info("The fitted model is: \n" + concreteOriginator.fitModel());
    // Asserts whether "Sequential B" was fitted: "Fitted Sequential B".
    assertEquals("Fitted Sequential B", concreteCaretaker.getDnn().getModelType());
  }
}