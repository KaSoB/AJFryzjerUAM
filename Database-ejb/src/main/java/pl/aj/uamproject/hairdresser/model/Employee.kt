package pl.aj.uamproject.hairdresser.model

import pl.aj.uamproject.hairdresser.infrastructure.IEntity

data class Employee(override var id : Int, var firstName : String, var lastName : String) : IEntity<Employee> {
    override fun update(o: Employee) {
        copy(id = id, firstName = firstName, lastName = lastName)
    }
}