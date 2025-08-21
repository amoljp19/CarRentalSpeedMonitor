class SpeedMonitor(
    private val userWarningDisplay: UserWarningDisplay
) {
    private var currentNotificationService: NotificationService? = null
    private var currentRental: Rental? = null

    fun startRentalSession(rental: Rental) {
        currentRental = rental
		
        currentNotificationService = when (rental.customer.preferredNotificationChannel) {
            NotificationChannel.FIREBASE -> FirebaseNotificationService()
            NotificationChannel.AWS -> AwsNotificationService()
        }
    }

    fun onSpeedUpdate(currentSpeed: Double) {
        currentRental?.let { rental ->
            if (currentSpeed > rental.maxSpeedLimit) {
                val warningMsg = "Speed Limit Exceeded..! Limit: ${rental.maxSpeedLimit}, Current: $currentSpeed"
                
                userWarningDisplay.displayWarning(warningMsg)
                
				// notify rental company via appropriate channel
                currentNotificationService?.notifyRentalCompany(rental, warningMsg)
            }
        } ?: run {
            println("Warning: No active rental session..!")
        }
    }
}