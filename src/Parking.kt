import java.util.*

data class Parking(
    val vehiclesList:MutableSet<Vehicle>


){
    val limit =19
    var parkingPair:Pair<Int,Int> = Pair(0,0)

    fun addVehicle(vehicle: Vehicle):Boolean{
        return if (vehiclesList.size<=limit){
            vehiclesList.add(vehicle)
            println("Welcome to Alkeparking")
            true
        }else {
            println("Sorry check-in failed")
            false
        }
    }

    fun workOfTheDay(){
        println("${parkingPair.first} vehicles have checked out and have earnings of ${parkingPair.second}")
    }
    fun listVehicle(){
        for (i in vehiclesList){
            println(i.plate)
        }
    }


}
