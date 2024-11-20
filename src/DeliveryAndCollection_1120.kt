import kotlin.math.max
import kotlin.math.min

class DeliveryAndCollection_1120 {
    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var answer: Long = -1

        var lastDeliveryIdx = deliveries.indexOfLast { it != 0 }
        var lastCollectionIdx = pickups.indexOfLast { it != 0 }

        var remainDeliveries = deliveries.sum()
        var remainCollections = pickups.sum()
        var distance = 0L
        while (remainDeliveries + remainCollections > 0) {

            var tempDistance = 0
            var currentStuff = cap
            while (currentStuff > 0 && lastDeliveryIdx >= 0) {
                if (deliveries[lastDeliveryIdx] == 0) {
                    lastDeliveryIdx -= 1
                    continue
                }
                tempDistance = max(tempDistance, lastDeliveryIdx)
                val diff = min(deliveries[lastDeliveryIdx], currentStuff)
                deliveries[lastDeliveryIdx] -= diff
                currentStuff -= diff
                remainDeliveries -= diff
                if (deliveries[lastDeliveryIdx] == 0) lastDeliveryIdx -= 1
            }

            currentStuff = 0
            while (currentStuff < cap && lastCollectionIdx >= 0) {
                if (pickups[lastCollectionIdx] == 0) {
                    lastCollectionIdx -= 1
                    continue
                }
                tempDistance = max(tempDistance, lastCollectionIdx)
                val diff = min((cap - currentStuff), pickups[lastCollectionIdx])
                pickups[lastCollectionIdx] -= diff
                currentStuff += diff
                remainCollections -= diff
                if (pickups[lastCollectionIdx] == 0) lastCollectionIdx -= 1
            }
            distance += (tempDistance+1)*2
        }

        return distance
    }
}
