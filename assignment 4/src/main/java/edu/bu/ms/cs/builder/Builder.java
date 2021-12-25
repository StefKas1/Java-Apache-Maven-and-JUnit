package edu.bu.ms.cs.builder;

// Builder pattern interface.
public interface Builder {
  BuildModel addModelType(String modelType);

  BuildModel addLayer(Layer layer);

  BuildModel addLossFunction(String lossFunction);

  BuildModel addOptimizer(String optimizer);

  BuildModel addMetric(String metric);

  DenseNeuralNetwork compile();
}
