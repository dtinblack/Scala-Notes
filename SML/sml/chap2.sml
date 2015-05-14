(* Examples From Chapter 2 *)

(* Greatest Common Denominator *)

fun gcd(0, n) = n
| gcd(m, n) = gcd( n mod m, m);

(* Run the examples *)

val gcd_res = gcd(36, 116);

"Result of gcd(36, 116): " ^ Int.toString gcd_res;



