package org.x4444.ml

/**
 * SimpleRegression
 *
 * Input Data Points (VW Jetta price (Year, USD))
 * (2001,4000)
 * (2002,4200)
 * (2003,4410)
 * (2004,4660)
 * (2005,4950)
 * (2006,5280)
 *
 * Formula: y = 254.28571428571428 * x - 504878.0952380952
 *
 * f(2000.0): 3693.333333333372
 * f(2001.0): 3947.619047619053
 * f(2003.5): 4583.333333333372
 * f(2007.0): 5473.333333333372
 */
object SimpleRegression {

  def simpleRegresion(data: List[(Double, Double)]): Double => Double = {
    val r = new org.apache.commons.math3.stat.regression.SimpleRegression()
    data.foreach({ case (x, y) => r.addData(x, y) })

    println("Input Data (VW Jetta price (Year, USD))")
    data.foreach(println)
    println
    println("Formula: y = " + r.getSlope + " * x" +
      (if (r.hasIntercept) (if (r.getIntercept >= 0) " + " else " - ") + math.abs(r.getIntercept)
      else "")
    )
    println
    println("MeanSquareError: " + r.getMeanSquareError)
    println("N: " + r.getN)
    println("R: " + r.getR)
    println("RegressionSumSquares: " + r.getRegressionSumSquares)
    println("RSquare: " + r.getRSquare)
    println("Significance: " + r.getSignificance)
    println("Slope: " + r.getSlope)
    println("SlopeConfidenceInterval: " + r.getSlopeConfidenceInterval)
    println("SlopeStdErr: " + r.getSlopeStdErr)
    println("SumOfCrossProducts: " + r.getSumOfCrossProducts)
    println("SumSquaredErrors: " + r.getSumSquaredErrors)
    println("TotalSumSquares: " + r.getTotalSumSquares)
    println("XSumSquares: " + r.getXSumSquares)
    println("hasIntercept: " + r.hasIntercept)
    println("Intercept: " + r.getIntercept)
    println("InterceptStdErr: " + r.getInterceptStdErr)
    r.predict(_)
  }
}
