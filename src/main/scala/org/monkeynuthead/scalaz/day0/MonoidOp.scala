package org.monkeynuthead.scalaz.day0

import scala.language.implicitConversions

trait MonoidOp[A] {
  val F: Monoid[A]
  val value: A
  def |+|(a2: A) = F.mappend(value, a2)
}

object MonoidOp {
  implicit def toMonoidOp[A: Monoid](a: A): MonoidOp[A] = new MonoidOp[A] {
    override val value: A = a
    override val F: Monoid[A] = implicitly[Monoid[A]]
  }
}
