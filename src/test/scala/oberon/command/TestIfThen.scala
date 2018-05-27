// package oberon.command

// import org.scalatest.FlatSpec
// import org.scalatest.Matchers
// import org.scalatest.GivenWhenThen
// import org.scalatest.BeforeAndAfter


// import oberon.Environment._
// import oberon.expression._
// import oberon.command._

// class TestIfThen extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

//   behavior of "an if then command"

//   before {
//     clear()
//   }

//   it should "lookup(soma) must be equal to 10" in {
//     val a1 = new Assignment("soma", IntValue(0))   
//     val a2 = new Assignment("val5", IntValue(5))      
//     val a3 = new Assignment("val10", IntValue(10))      
//     val a4 = new Assignment("soma", new AddExpression(new VarReference("soma"), new VarReference("val10")))
//     val cond = new LoExpression(new VarReference("val5"), new VarReference("val10"))
//     val w1 = new IfThen(cond, a4)

//     a1.run()
//     a2.run()
//     a3.run()
//     w1.run()

//     val res = lookup("soma")
//     res match {
//       case Some(v) => v.eval() should be (IntValue(10))
//       case _       => 0 should be (1)
//     }
//   }

//   it should "lookup(soma) must be equal to 15" in {
//     val a1 = new Assignment("soma", IntValue(0))   
//     val a2 = new Assignment("val5", IntValue(5))      
//     val a3 = new Assignment("val10", IntValue(10))  
//     val a4 = new Assignment("res", new AddExpression(new VarReference("val5"), new VarReference("val10")))    
//     val a5 = new Assignment("soma", new AddExpression(new VarReference("soma"), new VarReference("res")))
//     val cond = new LoExpression(new VarReference("val5"), new VarReference("val10"))
//     val w1 = new IfThen(cond, new BlockCommand(List(a4, a5)))

//     a1.run()
//     a2.run()
//     a3.run()
//     w1.run()

//     val res = lookup("soma")
//     res match {
//       case Some(v) => v.eval() should be (IntValue(15))
//       case _       => 0 should be (1)
//     }
//   }
// }
