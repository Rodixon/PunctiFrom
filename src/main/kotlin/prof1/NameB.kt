package prof1

class NameB: Condition {
    override fun isSuitable(person: Person): Boolean {
        return person.firstName.startsWith("R")
    }
}