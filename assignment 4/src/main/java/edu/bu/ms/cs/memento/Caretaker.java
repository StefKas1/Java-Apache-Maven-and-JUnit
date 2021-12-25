package edu.bu.ms.cs.memento;

// Memento pattern interface, Caretaker.
public interface Caretaker {
  void callSaveDenseNeuralNetwork();

  void callLoadDenseNeuralNetwork(int key);

}
