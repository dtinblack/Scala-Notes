(* Examples From Chapter 3 *)

(* Operations Involving Vectors *)

infix 6 vadd2  (* addition of 2-dim vectors        *)
infix 6 vsub2  (* subtraction of 2-dim vectors     *)
infix 7 tim2   (* multiplication of 2-dim vectors  *)
infix 6 dprod2 (* dot product of 2-dim vectors     *)

fun (x1, y1) vadd2 ( x2, y2) = (x1 + x2, y1 + y2): real*real;
fun (x1, y1) vsub2 ( x2, y2) = ( x1 - x2, y1 - y2): real * real;
fun x tim2 (x1, y1) = ( x*x1, x*y1): real * real; 
fun ( x1, y1) dprod2 ( x2, y2) =  x1*x2 + y1*y2: real;

fun norm2(x1, y1) = Math.sqrt(x1*x1 + y1*y1); (* using the Math.sqrt library *)

val a = (1.0, ~2.0);

val b = (3.0, 4.0);

val c = 2.0 tim2 a vsub2 b; (* read (2.0 tim2 a ) vsub2 b *)

val out1 = #1 c;

val out2 = #2 c;

"Result of 2.0 * ( 1.0, ~2.0) - ( 3.0, 4.0 ):  (" ^ Real.toString out1 ^ ", " ^ Real.toString out2 ^ " )";    

(* Quadratic Equations *)

type equation = real * real * real;

type solution = real * real;

exception Solve;

fun solve(a, b, c) = 
 if b*b - 4.0*a*c < 0.0 orelse Real.==(a, 0.0) then raise Solve (* "Real.==(a, 0.0)" because using NJ SML *) 
 else ( ( ~b + Math.sqrt( b * b - 4.0 * a * c ) )/ (2.0 * a ),
 ( ~b - Math.sqrt( b * b - 4.0 * a * c ) )/ ( 2.0 * a ) );
 
 val solution = solve(1.0, 1.0, ~2.0);
 
 val sol1 = #1 solution;
 
 val sol2 = #2 solution;
 
 "Result for a = 1.0, b = 1.0, c = -2: Root 1: " ^ Real.toString sol1 ^ "  Root 2: " ^ Real.toString sol2
   
