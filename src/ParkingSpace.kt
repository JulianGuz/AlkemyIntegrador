import java.util.*

class ParkingSpace(var vehicle: Vehicle) {

    val parkingTime: Long
        get() {
            return (Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / 60000
        }


    //val parking = Parking(mutableSetOf(auto,bus,minibus))
    var parking = Parking(mutableSetOf())


    fun imprimir() {
        //println(parking.vehiclesList.contains(auto))
    }


    fun checkOutVehicle(plate: String) {
        for (i in parking.vehiclesList) {
            if (i.plate == plate) {

                if (i.discount!=null){
                    onSuccess(calculateFee(i.parkingTime,i.type.type,true))
                }else{
                    onSuccess(calculateFee(i.parkingTime,i.type.type,false))
                }

                parking.vehiclesList.remove(i)
                break
            } else {
                onError()
            }
        }
    }

    private fun calculateFee(parkingTime: Long, type: Int, fee: Boolean): Int {
        var monto=0
        var mod =0
        if (parkingTime<120){
            monto = type
        }else{
            var extra = ((parkingTime.toInt() - 120)/ 15 )
            if (((parkingTime.toInt() - 120)%15) !=0){
               mod=1
            }
            monto= type+((extra+mod)*5)

            if (fee){
                monto-=(monto*15)/100
            }
        }
        return monto
    }

    fun onSuccess(res: Int) {
        parking.parkingPair=Pair(parking.parkingPair.first+1,parking.parkingPair.second+res)
        println("Your fee is $res . Come back soon.")

    }

    fun onError() {
        println("Sorry, the check-out failed")
    }


}

fun main(args: Array<String>) {

    val auto: Vehicle = Vehicle("BGF232", VehicleType.CAR, Calendar.getInstance())
    val auto2: Vehicle = Vehicle("DDF442", VehicleType.CAR, Calendar.getInstance())
    val auto3: Vehicle = Vehicle("JNG534", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val auto4: Vehicle = Vehicle("KMH555", VehicleType.CAR, Calendar.getInstance())
    val bus: Vehicle = Vehicle("MPD990", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val bus2: Vehicle = Vehicle("SSD422", VehicleType.BUS, Calendar.getInstance())
    val bus3: Vehicle = Vehicle("JNF746", VehicleType.BUS, Calendar.getInstance())
    val bus4: Vehicle = Vehicle("CNV099", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_003")
    val bus5: Vehicle = Vehicle("KNK444", VehicleType.BUS, Calendar.getInstance())
    val minibus: Vehicle = Vehicle("NDG534", VehicleType.MINIBUS, Calendar.getInstance())
    val minibus2: Vehicle = Vehicle("KND525", VehicleType.MINIBUS, Calendar.getInstance())
    val minibus3: Vehicle = Vehicle(" CXZ412", VehicleType.MINIBUS, Calendar.getInstance())
    val minibus4: Vehicle = Vehicle("LMF888", VehicleType.MINIBUS, Calendar.getInstance())
    val minibus5: Vehicle = Vehicle("MMG666", VehicleType.MINIBUS, Calendar.getInstance())
    val moto = Vehicle("AA001", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val moto2 = Vehicle("AA002", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val moto3 = Vehicle("AA003", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val moto4 = Vehicle("AA004", VehicleType.MOTORCYCLE, Calendar.getInstance(), "DISCOUNT_CARD_003")
    val moto5 = Vehicle("AA005", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val moto6 = Vehicle("AA006", VehicleType.MOTORCYCLE, Calendar.getInstance(), "DISCOUNT_CARD_004")
    val moto7 = Vehicle("AA007", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val parking = Parking(mutableSetOf())

    //println(parking.vehiclesList.contains(auto))

    fun check_in() {
        parking.addVehicle(auto)
        parking.addVehicle(auto2)
        parking.addVehicle(auto3)
        parking.addVehicle(auto4)
        parking.addVehicle(bus)
        parking.addVehicle(bus2)
        parking.addVehicle(bus3)
        parking.addVehicle(bus4)
        parking.addVehicle(bus5)
        parking.addVehicle(minibus)
        parking.addVehicle(minibus2)
        parking.addVehicle(minibus3)
        parking.addVehicle(minibus4)
        parking.addVehicle(minibus5)
        parking.addVehicle(moto)
        parking.addVehicle(moto2)
        parking.addVehicle(moto3)
        parking.addVehicle(moto4)
        parking.addVehicle(moto5)
        parking.addVehicle(moto6)
        parking.addVehicle(moto7)
    }
    check_in()

    val parkingspace = ParkingSpace(auto)
    parkingspace.parking =parking
    parkingspace.parking.workOfTheDay()
    parkingspace.checkOutVehicle(auto.plate)
    parkingspace.parking.workOfTheDay()
    parkingspace.parking.listVehicle()
}