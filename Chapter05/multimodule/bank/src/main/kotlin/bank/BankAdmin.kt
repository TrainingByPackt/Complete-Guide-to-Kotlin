package bank

class BankAdmin(private val bank: Bank) {
    fun transferTo(transferTo: Bank) {
        transferTo.deposit(bank.balance)
        bank.deleteAccount()
    }
}