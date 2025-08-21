fun main() {
    // Assume this is fetched configuration for customers
    val customer1 = Customer("C001", "Amol Pawar", NotificationChannel.FIREBASE)
    val customer2 = Customer("C002", "Akshay Pawal", NotificationChannel.AWS)

    val rentalForCustomer1 = Rental(customer1, maxSpeedLimit = 80.0)
    val rentalForCustomer2 = Rental(customer2, maxSpeedLimit = 100.0)

    val warningDisplay = ConsoleUserWarningDisplay()
    val speedMonitor = SpeedMonitor(warningDisplay)
	
    // Start rental session for Customer1 
    speedMonitor.startRentalSession(rentalForCustomer1)
    speedMonitor.onSpeedUpdate(70.0)  // No alert
    speedMonitor.onSpeedUpdate(85.0)  // Alert triggered for Customer1 (Firebase)

    // Switching rental session to Customer2
    speedMonitor.startRentalSession(rentalForCustomer2)
    speedMonitor.onSpeedUpdate(90.0)  // No alert
    speedMonitor.onSpeedUpdate(110.0) // Alert triggered for Customer2 (AWS)
}
