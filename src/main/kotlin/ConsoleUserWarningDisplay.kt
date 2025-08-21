class ConsoleUserWarningDisplay : UserWarningDisplay {
    override fun displayWarning(message: String) {
        println("USER WARNING: $message")
    }
}
