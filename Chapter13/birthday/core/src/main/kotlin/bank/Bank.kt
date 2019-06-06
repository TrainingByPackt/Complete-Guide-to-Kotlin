package bank

class Bank {
    var balance: Int = 0
        internal set

    fun deposit(amount: Int) {
        balance += amount
    }

    fun deleteAccount() {
        balance = 0
    }
}