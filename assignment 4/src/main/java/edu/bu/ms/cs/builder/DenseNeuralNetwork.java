package edu.bu.ms.cs.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import org.apache.log4j.Logger;

public class DenseNeuralNetwork {
  private static final Logger logger = Logger.getLogger(DenseNeuralNetwork.class);
  private final ArrayList<Layer> layers;
  private final String lossFunction;
  private final String optimizer;
  private final String metric;
  private String modelType;
  private byte[] modelWeights;

  /**
   * Constructor sets dense neural network's attributes.
   *
   * @param modelType    of dense neural network as String.
   * @param layers       of dense neural network as ArrayList.
   * @param lossFunction of dense neural network as String.
   * @param optimizer    of dense neural network as String.
   * @param metric       of dense neural network as String.
   */
  public DenseNeuralNetwork(String modelType, ArrayList<Layer> layers, String lossFunction,
                            String optimizer, String metric) {
    this.modelType = modelType;
    this.layers = layers;
    this.lossFunction = lossFunction;
    this.optimizer = optimizer;
    this.metric = metric;
  }

  /**
   * Checks whether dense neural network has been assembled from all necessary attributes.
   *
   * @return true if all attributes are included in dense neural network - as boolean.
   */
  public boolean isDenseNeuralNetworkCompletelyBuilt() {
    // If true: model is completely built and can be used for fitting.
    return modelType != null && lossFunction != null && optimizer != null && metric != null
        && layers.size() != 0;
  }

  /**
   * Fits dense neural network on data.
   *
   * @return this instance as DenseNeuralNetwork - fitted or unfitted.
   */
  public DenseNeuralNetwork fit() {
    // If true: dense neural network is incomplete and cannot be used for fitting, returns unfitted
    // model.
    if (!isDenseNeuralNetworkCompletelyBuilt()) {
      logger.info(
          "For fitting: Please create a complete model that includes a type, layer(s), "
              + "loss function, optimizer, and metric");
      return this; // Returns this unfitted dense neural network.
    }

    // Dense neural network is complete, sets number of epochs for fitting.
    int maxEpochs = 100;
    // Holds model weights determined by fitting as binary data in a byte array.
    modelWeights = new byte[maxEpochs]; // Initializes empty byte array.
    // Fits model: number 1 or 0 is randomly determined in each epoch and put in byte array.
    Random random = new Random();
    for (int epoch = 1; epoch <= maxEpochs; epoch++) {
      modelWeights[epoch - 1] = (byte) (random.nextBoolean() ? 1 : 0);
      // Logs every 10 epochs.
      if (epoch % 10 == 0) {
        logger.info("Fit after epoch: " + epoch); // Could be implemented with a callback function.
      }
    }
    modelType = "Fitted " + modelType;
    return this; // Returns this fitted dense neural network.
  }

  /**
   * Gets model type.
   *
   * @return modelType as String.
   */
  public String getModelType() {
    return modelType;
  }

  /**
   * Builds String which contains entire dense neural network information.
   *
   * @return dense neural network information as String.
   */
  @Override
  public String toString() {
    return "DenseNeuralNetwork{"
        + "modelType='" + modelType + '\''
        + ", layers=" + layers.toString()
        + ", lossFunction='" + lossFunction + '\''
        + ", optimizer='" + optimizer + '\''
        + ", metric='" + metric + '\''
        + ", modelWeights='" + Arrays.toString(modelWeights) + '\''
        + '}';
  }
}
