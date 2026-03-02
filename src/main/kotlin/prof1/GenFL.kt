package prof1

class GenFL: Condition {
    override fun isSuitable(person: Person): Boolean {
        return person.gender == Gender.FEMALE
    }
}