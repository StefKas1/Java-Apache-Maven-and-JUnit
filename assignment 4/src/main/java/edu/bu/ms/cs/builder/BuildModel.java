package edu.bu.ms.cs.builder;

import java.util.ArrayList;
import org.apache.log4j.Logger;

// Builder pattern.
public class BuildModel implements Builder {
  private static final Logger logger = Logger.getLogger(BuildModel.class);
  private final ArrayList<Layer> layers = new ArrayList<>();
  private String modelType;
  private String lossFunction;
  private String optimizer;
  private String metric;

  /**
   * Adds model type to BuildModel.
   *
   * @param modelType of dense neural network as String.
   * @return this instance as BuildModel.
   */
  @Override
  public BuildModel addModelType(String modelType) {
    this.modelType = modelType; // Sets model type in this BuildModel object.
    return this; // Returns this instance of BuildModel.
  }

  /**
   * Adds layer to BuildModel.
   *
   * @param layer of dense neural network as Layer.
   * @return this instance as BuildModel.
   */
  @Override
  public BuildModel addLayer(Layer layer) {
    layers.add(layer);
    return this;
  }

  /**
   * Adds loss function to BuildModel.
   *
   * @param lossFunction of dense neural network as String.
   * @return this instance as BuildModel.
   */
  @Override
  public BuildModel addLossFunction(String lossFunction) {
    this.lossFunction = lossFunction;
    return this;
  }

  /**
   * Adds optimizer to BuildModel.
   *
   * @param optimizer of dense neural network as String.
   * @return this instance as BuildModel.
   */
  @Override
  public BuildModel addOptimizer(String optimizer) {
    this.optimizer = optimizer;
    return this;
  }

  /**
   * Adds metric to BuildModel.
   *
   * @param metric of dense neural network as String.
   * @return this instance as BuildModel.
   */
  @Override
  public BuildModel addMetric(String metric) {
    this.metric = metric;
    return this;
  }

  /**
   * Assembles BuildModel into a DenseNeuralNetwork.
   *
   * @return denseNeuralNetwork as DenseNeuralNetwork
   */
  @Override
  public DenseNeuralNetwork compile() {
    // Creates (assembles) a dense neural network form BuildModel attributes.
    DenseNeuralNetwork denseNeuralNetwork =
        new DenseNeuralNetwork(modelType, layers, lossFunction, optimizer, metric);
    logger.info("Model compiled: " + denseNeuralNetwork);
    return denseNeuralNetwork;
  }
}
