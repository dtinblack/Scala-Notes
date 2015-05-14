// Trees.scala
//
//

package trees


sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {

    def size[A](tree: Tree[A]): Int = tree match {
        case l:Leaf[A] => 1
        case b:Branch[A] => 1 + size(b.left) + size(b.right)
    } 
       
    
    def countLeaves[A](tree: Tree[A]): Int = tree match {
        case l:Leaf[A] => 1
        case b:Branch[A] => countLeaves(b.left) + countLeaves(b.right)
    }  
    
    def getLeaves[A](tree: Tree[A]): List[Leaf[A]] = tree match {
      case l:Leaf[A] => List(l)
      case b:Branch[A] => getLeaves(b.left) ++ getLeaves(b.right)
    }
    
    def printLeaves[A]( leaves: List[Leaf[A]] ): Unit = leaves match {
           case Nil => // do nothing
           case head::tail => println(getValue( head ))
                              printLeaves(tail)
    }                          
    
    def getValue[A]( l: Leaf[A]): A = l match { case Leaf(a) => a }


}


case class BSTree[+T](value: T, left: Option[BSTree[T]], right: Option[BSTree[T]]) {

    def inOrder[A](t: Option[BSTree[A]], f: BSTree[A] => Unit): Unit = t match {
        case None => // do nothing
        case Some(x) =>
            if ( x.left != None) inOrder(x.left, f)
            f(x)
            if ( x.right != None) inOrder( x.right, f )  
    } 
    
    def preOrder[A](t: Option[BSTree[A]], f:BSTree[A] => Unit): Unit = t match {
        case None => // do nothing
        case Some(x) =>
            f(x)
            if( x.left != None ) inOrder(x.left, f)
            if( x.right != None ) inOrder(x.right, f) 
    }   
    
    def postOrder[A](t: Option[BSTree[A]], f:BSTree[A] => Unit): Unit = t match {
        case None => // do nothing
        case Some(x) =>
            if( x.left != None ) inOrder(x.left, f)
            if( x.right != None ) inOrder(x.right, f)
            f(x) 
    } 
    
                     
    def compare[A]( tree1: Option[BSTree[A]], tree2: Option[BSTree[A]] ): Boolean = { 
    
      def check[A](tr1: Option[BSTree[A]], tr2: Option[BSTree[A]]): Boolean = (tr1, tr2 ) match {
            case (None, None) => true
            case ( Some(t1), Some(t2) ) => compare( Some(t1), Some(t2) )
            case _ => false
        }
       
              
        ( tree1, tree2 ) match {
            
             case( Some( BSTree(v1, l1, r1) ), Some( BSTree(v2, l2, r2) ) ) if( v1 == v2 ) => 
                                             check(l1,l2) && check(r1,r2)
                                                                                
             case _ => false
       } 
       
    }   

}