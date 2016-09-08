package dk.cphbusiness.challengeone.model

/*
 val firstName
 var lastName
 var age
 --
 haveBirthDay()
 marryTo(other: Person)
 divorce()
 */

open class Person(val firstName: String, var lastName: String) {
    private var spouse: Person? = null

    var age = 0
        get() = field

    fun haveBirthDay() {
        age += 1
        }

    fun marryTo(other: Person): Unit {
        // No need to declare "Unit"
        if (spouse != null) throw RuntimeException("Already married")
        if (other.spouse != null) throw RuntimeException("Other person already married")
        spouse = other
        other.spouse = this
        lastName = other.lastName
        }

    fun isMarried() = spouse != null

    fun divorce() {
//        if (spouse == null) return
//        // Her kan en anden tråd ændre spouse i this
//        spouse.spouse = null
        }

    override fun toString() = firstName+" "+lastName
    }

abstract class Employee(firstName: String, lastName: String) : Person(firstName, lastName) {
    abstract val payment: Int
    }

class Indian(firstName: String, lastName: String, var salary: Int) : Employee(firstName, lastName) {
    override val payment: Int
        get() = salary/12
    }

class Chief(
        firstName: String,
        lastName: String,
        var fee: Int,
        var bonus: Int = 0,
        var percentage: Int = 0
        ) : Employee(firstName, lastName) {

    override val payment: Int
        get() = (fee + bonus)*(100 + percentage)/100

    }