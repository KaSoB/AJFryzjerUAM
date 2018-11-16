package pl.aj.uamproject.hairdresser.model

import pl.aj.uamproject.hairdresser.infrastructure.IEntity

data class Client(override var id : Int, var firstName: String, var lastName : String, var email : String, var phoneNumber : String) : IEntity<Client> {
    override fun update(o:Client) {
        copy(id = o.id, firstName = o.firstName, lastName = o.lastName, email = o.email, phoneNumber = o.phoneNumber)
    }
}

