package prof1

fun main() {

        val profiles = RepoProfil.profiles
//        for (profile in profiles) {
//                println(profile)
//        }

        val p= filterMAle(filterB(filter25(profiles)))
        for (ps in p){
                println(ps)
        }





}

fun filter25(persones: List<Person>): List<Person> {
        val filteredPersons = mutableListOf<Person>()
        for (person in persones) {
                if (person.age>25){
                        filteredPersons += person
                }
        }
        return filteredPersons
}

fun filterB(persones: List<Person>): List<Person> {
        val filteredPersons = mutableListOf<Person>()
        for (person in persones) {
                if (person.firstName.startsWith("B")){
                        filteredPersons += person
                }
        }
        return filteredPersons
}

fun filterMAle(persones: List<Person>): List<Person> {
        val filteredPersons = mutableListOf<Person>()
        for (person in persones) {
                if (person.gender == Gender.MALE){
                        filteredPersons += person
                }
        }
        return filteredPersons
}





