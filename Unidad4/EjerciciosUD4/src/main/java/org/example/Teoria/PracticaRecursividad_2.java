package org.example.Teoria;

// Implementa un programa que sume los números del 1 al 10 sin usar bucles.
public class PracticaRecursividad_2 {
 public static int suma (int num) {
     if (num == 0) {
         return 0;
     } else {
         return num + suma(num - 1);
     }
 }
}
