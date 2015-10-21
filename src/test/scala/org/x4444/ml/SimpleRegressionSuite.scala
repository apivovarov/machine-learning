package org.x4444.ml

import org.scalatest.FunSuite
import org.x4444.ml.SimpleRegression.simpleRegresion

class SimpleRegressionSuite extends FunSuite {

  /**
   * f(2000.0): 3693.333333333372
   * f(2001.0): 3947.619047619053
   * f(2003.5): 4583.333333333372
   * f(2007.0): 5473.333333333372*
   */
  test("simpleRegression") {
    val data = List[(Double, Double)](
      (2001, 4000),
      (2002, 4200),
      (2003, 4410),
      (2004, 4660),
      (2005, 4950),
      (2006, 5280)
    )
    val f = simpleRegresion(data)

    println

    List[Double](2000, 2001, 2003.5, 2007).
      foreach(x => println("f(" + x + "): " + f(x)))
  }

}
