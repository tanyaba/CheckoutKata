package utils

import com.itv.{Promotion, Sku}

object TestData {

  val offer1 = Promotion(3, 1.30)
  val offer2 = Promotion(2, 0.45)
  val skuA = Sku("A", 0.50, Some(offer1))
  val skuB = Sku("B", 0.30, Some(offer2))
  val skuC = Sku("C", 0.20, None)

}
