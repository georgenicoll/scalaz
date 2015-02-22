package org.monkeynuthead.scalaz

case class TrafficLight(name: String)

object TrafficLight {
  val green = TrafficLight("green")
  val amber = TrafficLight("amber")
  val red = TrafficLight("red")
}