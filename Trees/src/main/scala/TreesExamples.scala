// TreesExamples.scala
//
//


package treesexample

import trees._

object TreesExample {


     def main(args: Array[String]): Unit = {
     
     println("Program started ...")
     
     val tree1 = Branch(Branch(Leaf(1), Leaf(2)), Branch(Branch(Leaf(3),Leaf(4)),Leaf(5)))
     
     println( tree1 )
     
     println("Size of tree: " + Tree.size( tree1 ) )
     
     println("Number of Leaves: " + Tree.countLeaves( tree1 ))
     
     println("Get leaves: " + Tree.getLeaves( tree1 ))
     
     Tree.printLeaves( Tree.getLeaves( tree1 ) )
     
   // Binary Search Tree example
               
     val bst = BSTree(6, 
     
                      Some(BSTree(5,
                                    Some(BSTree(2, None, None)),
                                    Some(BSTree(5, None, None))
                                 )
                          ) 
                      , 
                      Some(BSTree(7,
                                    None,
                                    Some(BSTree(8,None,None))
                                  )
                           )
                      )
                      
    val bst1 = BSTree(7, 
     
                      Some(BSTree(5,
                                    Some(BSTree(2, None, None)),
                                    Some(BSTree(2, None, None))
                                 )
                          ) 
                      , 
                       None
                      )               
                      
                       
     
     println( bst )
     
     println( bst1 )  
    
     val func = (t:BSTree[Int] ) => t match { case BSTree(a,b,c) => println( a ) }
     
     println("BST In Order")
     
     bst.inOrder( Some(bst), func )
     
     println("BST In Pre Order")
     
     bst.preOrder( Some(bst), func )
     
     println("BST in Post Order")
     
     bst.postOrder( Some( bst ), func )
     
//     println( bst.output( Some(bst), Some(bst1) ) )
     
    println( bst.compare( Some(bst), Some(bst1) ) )


  
  
     }

}
