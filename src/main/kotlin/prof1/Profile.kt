package prof1

fun main() {

    val profiles = RepoProfil.profiles

    val p = filterMAle(filterB(filter25(profiles)))

    var d = filter(profiles, AgePers())

    d = filter(profiles, NameB())
    d = filter(profiles, GenFL())
    d = filter(profiles, GenML())

    d = filter(profiles, object : Condition {
        override fun isSuitable(person: Person): Boolean {
            return person.firstName.startsWith("Z")
        }
    })

    val olderAge:(pers: Person)-> Boolean = {pers: Person -> pers.age>84}
    val dd25age = filterLmb(profiles,olderAge)

    val prsStrtX = filterLmb(profiles) { person -> person.firstName.startsWith("X") }

    val prsMale = filterLmb(profiles){  it.gender == Gender.FEMALE  }

    for (ps in prsMale) {
        println(ps)
    }


}


fun filterLmb(persones: List<Person>, isSuitable:(Person)-> Boolean): List<Person> {
    val filteredPersons = mutableListOf<Person>()
    for (person in persones) {
        if (isSuitable(person)) {
            filteredPersons += person
        }
    }
    return filteredPersons
}

fun filter(persones: List<Person>, condition: Condition): List<Person> {
    val filteredPersons = mutableListOf<Person>()
    for (person in persones) {
        if (condition.isSuitable(person)) {
            filteredPersons += person
        }
    }
    return filteredPersons
}

fun filter25(persones: List<Person>): List<Person> {
    val filteredPersons = mutableListOf<Person>()
    for (person in persones) {
        if (person.age > 25) {
            filteredPersons += person
        }
    }
    return filteredPersons
}

fun filterB(persones: List<Person>): List<Person> {
    val filteredPersons = mutableListOf<Person>()
    for (person in persones) {
        if (person.firstName.startsWith("B")) {
            filteredPersons += person
        }
    }
    return filteredPersons
}

fun filterMAle(persones: List<Person>): List<Person> {
    val filteredPersons = mutableListOf<Person>()
    for (person in persones) {
        if (person.gender == Gender.MALE) {
            filteredPersons += person
        }
    }
    return filteredPersons
}





