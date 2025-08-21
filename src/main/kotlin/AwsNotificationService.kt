class AwsNotificationService : NotificationService {
    override fun notifyRentalCompany(rental: Rental, message: String) {
        // TODO: Call AWS SNS or similar API here
        println("AWS notification sent for customer ${rental.customer.name}: $message")
    }
}
