package unit

import com.itv.Checkout
import org.scalatest.{WordSpec, _}
import utils.TestData._

class CheckoutSpec extends WordSpec with Matchers {
  "Checkout" should {
    "accept items in any order and apply special offers correctly" in {

      val items1 = List(skuA, skuB, skuC, skuA, skuB, skuA, skuA)
      val items2 = List(skuB, skuA, skuB)

      val customer1 = Checkout(items1)
      val customer2 = Checkout(items2)

      customer1.totalPrice shouldBe 2.45
      customer2.totalPrice shouldBe 0.95

    }
    "not apply multi-priced discount if a required minimum number of items not purchased " in {

      Checkout(List(skuA)).totalPrice shouldBe skuA.unitPrice

    }


  }



}
