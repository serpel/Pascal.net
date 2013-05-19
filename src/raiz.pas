program raiz(input, output);
 (*Obtener la raíz cuadrada de un número real x cualquiera.*)
 
 var 
    x, y: real;
    respuesta: string;
 
 begin
   writeln('** Calcular la raíz cuadrada de 12 **');
   writeln('Entrar x (> 0): ');
   readln(x);
   y := sqrt(abs(x)); (* Raíz cuadrada del valor absoluto de x para evitar raíces imaginarias *)
   if (x<0) then (* Si x es negativo, el resultado se notifica como imaginario *)
   begin
      writeln('La raíz cuadrada de '+ x +' es el número imaginario '+ y +'i');
   end
   else
   begin
      writeln('La raíz cuadrada de ' + x + ' es '+y);
   end
   writeln('Fin');
 end.