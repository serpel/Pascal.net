program raiz();
 (*Obtener la raíz cuadrada de un número real x cualquiera.*)
 
 var 
    x: int;
 
 begin
   x := 1;

   if ((x = 1) or (x > 1)) then
   begin
        x := x + 3 * 4;
   end

   writeln(x);

 end.