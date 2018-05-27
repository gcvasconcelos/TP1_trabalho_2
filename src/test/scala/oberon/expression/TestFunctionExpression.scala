// package oberon.expression

// import org.scalatest.FlatSpec
// import org.scalatest.Matchers
// import org.scalatest.GivenWhenThen
// import org.scalatest.BeforeAndAfter

// import oberon.Environment._
// import oberon.expression._
// import oberon.command._

// class TestFunctionExpression extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

//   behavior of "function expressions"

//   it should "func.eval should be 10" in {
//     val a1 = new Assignment("val5", IntValue(5))
//     val a2: IntValue = null
//     val soma = new Assignment("soma", new AddExpression(new VarReference("val5"), new VarReference("val5")))
//     val func = new FunctionExpression(a1, soma, a2)


//     func.eval() should be (IntValue(10)) 
//   }
// }
