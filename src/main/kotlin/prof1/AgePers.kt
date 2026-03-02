package prof1

class AgePers: Condition {
    override fun isSuitable(person: Person): Boolean {
        return person.age>45
    }
}



