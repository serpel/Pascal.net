program raiz();
 (*Obtener la raíz cuadrada de un número real x cualquiera.*)
 
 var 
    x: int;
 
 begin
   x := 1;

   repeat 
   begin 
        x := x + 1; 
   end
   until x > 1 ; 

   writeln(x);

 end.