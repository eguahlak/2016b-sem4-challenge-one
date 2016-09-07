package dk.cphbusiness.challengeone

import dk.cphbusiness.challengeone.model.Chief
import dk.cphbusiness.challengeone.model.Indian
import dk.cphbusiness.challengeone.model.Person
import org.junit.Test

import org.junit.Assert.*

class ExampleUnitTest {

    @Test
    fun testCreatePerson() {
        val kurt = Person("Kurt", "Hansen")
        assertEquals("Kurt", kurt.firstName)
        assertEquals("Hansen", kurt.lastName)
        assertEquals(0, kurt.age)
        }

    @Test
    fun testCreatePersonWithBirthday() {
        val kurt = Person("Kurt", "Hansen")
        kurt.haveBirthDay()
        assertEquals("Kurt", kurt.firstName)
        assertEquals("Hansen", kurt.lastName)
        assertEquals(1, kurt.age)
    }

    @Test
    fun testMarryTo() {
        val kurt = Person("Kurt", "Hansen")
        val sonja = Person("Sonja", "Jensen")
        kurt.marryTo(sonja)
        assertEquals("Jensen", kurt.lastName)
        assertTrue(kurt.isMarried())
        assertTrue(sonja.isMarried())
        }

    @Test
    fun testIndianPayment() {
        val indian = Indian("Kurt", "Hansen", 240000)
        assertEquals(20000, indian.payment)
        }

    @Test
    fun testChiefPayment() {
        val chief = Chief("Sonja", "Jensen", 1200000)
        assertEquals(1200000, chief.payment)
        assertEquals(0, chief.bonus)
        assertEquals(0, chief.percentage)
        }

    @Test
    fun testChiefPaymentDefaul() {
        val chief = Chief("Sonja", "Jensen", 1200000, percentage = 10)
        assertEquals(1320000, chief.payment)
        assertEquals(0, chief.bonus)
        assertEquals(10, chief.percentage)
        assertEquals("Sonja", chief.firstName)
    }

    @Test
    fun testChiefPaymentMore() {
        val chief = Chief(
                lastName = "Jensen",
                firstName = "Sonja",
                fee = 1200000,
                percentage = 10
                )
        assertEquals(1320000, chief.payment)
        assertEquals(0, chief.bonus)
        assertEquals(10, chief.percentage)
        assertEquals("Sonja", chief.firstName)
    }


}