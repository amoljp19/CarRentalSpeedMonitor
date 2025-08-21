class FirebaseNotificationService : NotificationService {
    override fun notifyRentalCompany(rental: Rental, message: String) {
        // TODO: Call Firebase API here
        println("Firebase notification sent for customer ${rental.customer.name}: $message")
    }
}
