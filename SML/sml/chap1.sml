(* Examples From Chapter 1 *)

(* Factorial *)

fun fact 0 = 1
| fact n = n * fact( n-1 );

(* Fibonacci Series *)

fun fib 0 = 1
| fib 1 = 1
| fib n = fib(n-1) + fib(n-2);

(* Run the examples *)

val fact_res = fact(6);

"Result of fac(6): " ^ Int.toString fact_res;

val fib_res = fib(6);

"Result of fib(6): " ^ Int.toString fib_res;

