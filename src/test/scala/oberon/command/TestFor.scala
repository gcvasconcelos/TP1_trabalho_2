// package oberon.command

// import org.scalatest.FlatSpec
// import org.scalatest.Matchers
// import org.scalatest.GivenWhenThen
// import org.scalatest.BeforeAndAfter


// import oberon.command._
// import oberon.expression._
// import oberon.Environment._


// class TestFor extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

//   behavior of "a for command"

//   before {
//     clear()
//   }

//   it should "loop for should work correclty" in {
//     val x = new VarDeclaration("x")
//     x.run
//     val newx = new Assignment("x", IntValue(0))
//     newx.run

//     val i  = new VarDeclaration("i")
//     i.run

//     val _for = new For(
//       new Assignment("i", IntValue(0)), 
//       new LoExpression(VarReference("x"), IntValue(6)),
//       new AddExpression(VarReference("i"), IntValue(1)),
//       new MultExpression(
//         new Assignment(VarReference("x")), 
//         new AddExpression(VarReference("x"), IntValue(2))
//         )
//       )
//     _for.run

//     lookup("x") match {
//       case Some(map) => map("x") should be (Undefined()) 
//       case _         => 1 should be (0)
//     }
//   }
// }
