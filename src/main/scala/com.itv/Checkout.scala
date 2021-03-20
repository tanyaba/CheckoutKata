package com.itv

case class Checkout(items: List[Sku]) {

  val totalPrice: Double = items.groupBy(_.id).map{
    skuGroup =>
      val quantity = skuGroup._2.length
     getIndividualTotal(skuGroup._2.head, quantity)
  }.sum

  private def getIndividualTotal(sku: Sku, quantities: Int): Double = {
    sku.promotion match {
      case None => sku.unitPrice * quantities
      case Some(promo) =>
        val nonPromoQuantity = quantities % promo.units
        val promoQuantity = (quantities - nonPromoQuantity) / promo.units
        nonPromoQuantity * sku.unitPrice + promoQuantity * promo.price

    }

  }
}



