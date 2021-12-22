import java.util.*

class Vehicle(
    val plate: String,
    val type: VehicleType,
    val checkInTime: Calendar,
    val discount: String? = null
) {

    val parkingTime: Long
        get() {
            return (Calendar.getInstance().timeInMillis - checkInTime.timeInMillis) / 60000
        }

    override fun equals(other: Any?): Boolean {
        if (other is Vehicle) {
            return this.plate == other.plate
        }
        return super.equals(other)
    }

    override fun hashCode(): Int = this.plate.hashCode()

    fun hasDiscount(): Int {
        return if (discount != null) {
            15
        } else {
            0
        }
    }

}




