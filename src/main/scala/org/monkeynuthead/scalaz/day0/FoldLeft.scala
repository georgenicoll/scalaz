package org.monkeynuthead.scalaz.day0

import scala.language.higherKinds

trait FoldLeft[F[_]] {
  def foldLeft[A, B](xs: F[A], b: B, f: (B, A) => B): B
}

object FoldLeft {
  implicit val FoldLeftList: FoldLeft[List] = new FoldLeft[List] {
    override def foldLeft[A, B](xs: List[A], b: B, f: (B, A) => B) = xs.foldLeft(b)(f)
  }

  implicit val FoldLeftSeq: FoldLeft[Seq] = new FoldLeft[Seq] {
    override def foldLeft[A, B](xs: Seq[A], b: B, f: (B, A) => B): B = xs.foldLeft(b)(f)
  }

  def sum[M[_]: FoldLeft, A: Monoid](xs: M[A]): A = {
    val m = implicitly[Monoid[A]]
    val fl = implicitly[FoldLeft[M]]
    fl.foldLeft(xs, m.mzero, m.mappend)
  }
}
