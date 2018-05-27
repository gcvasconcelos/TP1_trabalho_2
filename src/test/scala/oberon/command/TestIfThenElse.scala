// package oberon.command

// import org.scalatest.FlatSpec
// import org.scalatest.Matchers
// import org.scalatest.GivenWhenThen
// import org.scalatest.BeforeAndAfter


// import oberon.Environment._
// import oberon.expression._
// import oberon.command._

// class TestIfThenElse extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

//   behavior of "an if then else command"

//   before {
//     clear()
//   }

//   it should "lookup(result) must be equal to 5" in {
//     val a1 = new Assignment("result", IntValue(0))   
//     val a2 = new Assignment("val5", IntValue(5))      
//     val a3 = new Assignment("val10", IntValue(10))      
//     val a4 = new Assignment("result", new AddExpression(new VarReference("val5"), new VarReference("val10")))
//     val a5 = new Assignment("result", new SubExpression(new VarReference("val10"), new VarReference("val5")))
//     val cond = new GrExpression(new VarReference("val5"), new VarReference("val10"))
//     val w1 = new IfThenElse(cond, a4, a5)

//     a1.run()
//     a2.run()
//     a3.run()
//     w1.run()

//     val res = lookup("result")
//     res match {
//       case Some(v) => v.eval() should be (IntValue(5))
//       case _       => 0 should be (1)
//     }
//   }

// }
