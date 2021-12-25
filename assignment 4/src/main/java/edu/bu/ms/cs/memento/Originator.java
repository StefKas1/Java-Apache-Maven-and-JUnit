package edu.bu.ms.cs.memento;

import edu.bu.ms.cs.memento.ConcreteOriginator.Memento;


// Memento pattern interface, Originator.
public interface Originator {
  Memento saveDenseNeuralNetwork();

  void loadDenseNeuralNetwork(Memento savedMemento);
}
