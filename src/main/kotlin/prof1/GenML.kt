package prof1

class GenML: Condition {
    override fun isSuitable(person: Person): Boolean {
        return person.gender  == Gender.MALE
    }
}