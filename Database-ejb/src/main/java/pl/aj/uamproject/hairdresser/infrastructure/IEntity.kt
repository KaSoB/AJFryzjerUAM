package pl.aj.uamproject.hairdresser.infrastructure

interface IEntity<in T> {
    var id: Int
    fun update(o : T)
}