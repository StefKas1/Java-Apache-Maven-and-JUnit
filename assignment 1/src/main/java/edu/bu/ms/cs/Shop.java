package edu.bu.ms.cs;

// Observable interface.
public interface Shop {
  void registerDriver(Driver driver);

  void removeDriver(Driver driver);

  void notifyDrivers(DeliveryRequest deliveryRequest);
}
