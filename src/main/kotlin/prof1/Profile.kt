package prof1

import AllExtentions.fore4
import AllExtentions.transformLineAE


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
    val olderAge: (pers: Person) -> Boolean = { pers: Person -> pers.age > 84 }
    val dd25age = filterLmb(profiles, olderAge)
    val prsStrtX = filterLmb(profiles) { person -> person.firstName.startsWith("X") }
    val prsMale = filterLmb(profiles) { it.gender == Gender.FEMALE }

    val newList = filterGeneric(profiles) { it.age > 40 }

    val profilesExt = RepoProfil.profiles
    //.filterExt {it.firstName.startsWith("W")  }
    //.filterExt {it.firstName.startsWith("x")  }
    //.transformExt {  }
    //.transformLineAE{}
    //.minBy { it.age }

    //profilesExt.sortedBy { it.firstName }.fore4 { println("${it.firstName} -- ${it.email}") }

//    for (ps in newList) {
//        println(ps)
//    }
    showEmail()



}
fun showEmail() {
    println("enter id ")
    val a = readln().toInt()
    RepoProfil.profiles
        .find{it.id == a}?.email
        .let { if (it!=null) println(it)else println("no such adress") }

}


fun <T, R> List<T>.transformExt(trns: (T) -> R): List<R> {
    val fltr = mutableListOf<R>()
    for (a22 in this) {
        fltr.add(trns(a22))
    }
    return fltr
}

fun List<Person>.filterExt(isSuitable: (Person) -> Boolean): List<Person> {
    val filteredPersons = mutableListOf<Person>()
    for (person in this) {
        if (isSuitable(person)) {
            filteredPersons += person
        }
    }
    return filteredPersons
}


fun <R> List<Person>.filterGenericExt(modification: (Person) -> R): List<R> {
    val filteredPersons = mutableListOf<R>()
    for (person in this) {
        filteredPersons.add(modification(person))
    }
    return filteredPersons
}

fun <T, R> transform(a: List<T>, trns: (T) -> R): List<R> {
    val fltr = mutableListOf<R>()
    for (a22 in a) {
        fltr.add(trns(a22))
    }
    return fltr
}

fun <R> filterGeneric(persones: List<Person>, modification: (Person) -> R): List<R> {
    val filteredPersons = mutableListOf<R>()
    for (person in persones) {
        filteredPersons.add(modification(person))
    }
    return filteredPersons
}


fun filterLmb(persones: List<Person>, isSuitable: (Person) -> Boolean): List<Person> {
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





