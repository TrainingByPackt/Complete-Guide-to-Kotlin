package main

import bank.Bank
import bank.BankAdmin

fun main() {
	val bank = Bank()
	bank.deposit(10)
	println("balance: ${bank.balance}")
	bank.deleteAccount()
	println("balance: ${bank.balance}")


//	val bankOne = Bank()
//	val bankTwo = Bank()
//	bankOne.deposit(10)
//	println("balance: ${bankOne.balance}")
//	BankAdmin(bankOne).transferTo(bankTwo)
//	println("balance bankOne: ${bankOne.balance} bankTwo: ${bankTwo.balance}")
}
