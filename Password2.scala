package git

import java.util.Random
object Password2 extends App {

  val upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
  val lower = "abcdefghijklmnopqrstuvwxyz"
  val special = "!@#$%^&*()_-+=<>?"
  val digits = "0123456789"

  def genPassword(length: Int, useLower: Boolean, useUpper: Boolean, useDigits: Boolean, useSpecial: Boolean): String = {
    val validChars = StringBuilder.newBuilder
    if (useUpper) validChars ++= upper
    if (useLower) validChars ++= lower
    if (useSpecial) validChars ++= special
    if (useDigits) validChars ++= digits

    val random = new Random
    val password = StringBuilder.newBuilder

    for (_ <- 1 to length) {
      val randomIndex = random.nextInt(validChars.length)
      password += validChars(randomIndex)
    }
    password.toString()
  }

  def run(args: Array[String]): Unit = {
    val password = genPassword(12, useLower = true, useUpper = true, useDigits = true, useSpecial = true)
    println("Password: " + password)

  }

  run(args)

}
