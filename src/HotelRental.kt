import kotlin.collections.ArrayList

class HotelRental {
    fun solution(book_time: Array<Array<String>>) {
        val reserve = ArrayList<ReservationTime>()
        for (one in book_time) {
            reserve.add(toReserveTime(one[0], one[1]))
        }
        reserve.sortWith(
            java.util.Comparator.comparing<ReservationTime, Int> { it.from }
                .thenComparing(java.util.Comparator.comparing { it.to })
        )
        val rooms = mutableListOf<Int>()
        var roomAssigned = false
        for (checkIn in reserve) {
            roomAssigned = false
            for (no in rooms.indices) {
                if (checkIn.from < rooms[no]) continue
                rooms[no] = checkIn.to + 10
                roomAssigned = true
                break
            }
            if (!roomAssigned) rooms.add(checkIn.to + 10)
        }

    }

    fun toReserveTime(from: String, to: String): ReservationTime {
        val startTime = toMinute(from)
        val endTime = toMinute(to)
        return ReservationTime(startTime, endTime)
    }

    fun toMinute(time: String): Int {
        val splitTime = time.trim('\"').split(":")
        return splitTime[0].toInt() * 60 + splitTime[1].toInt()
    }

    data class ReservationTime(
        val from: Int,
        val to: Int
    )
}
