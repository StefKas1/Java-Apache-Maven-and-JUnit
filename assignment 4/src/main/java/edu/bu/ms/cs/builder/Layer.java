package edu.bu.ms.cs.builder;

public class Layer {
  private final String connectionType;
  private final int numberNeurons;
  private final String activationFunction;

  /**
   * Constructor sets layer's attributes.
   *
   * @param connectionType     of dense neural network as String.
   * @param numberNeurons      of dense neural network as int.
   * @param activationFunction of dense neural network as String.
   */
  public Layer(String connectionType, int numberNeurons, String activationFunction) {
    this.connectionType = connectionType;
    this.numberNeurons = numberNeurons;
    this.activationFunction = activationFunction;
  }

  /**
   * Builds String which contains entire layer information.
   *
   * @return layer information as String.
   */
  @Override
  public String toString() {
    return "Layer{"
        + "connectionType='" + connectionType + '\''
        + ", numberNeurons=" + numberNeurons
        + ", activationFunction='" + activationFunction + '\''
        + '}';
  }
}
