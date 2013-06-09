program raiz(input, output);
 (*Obtener la raíz cuadrada de un número real x cualquiera.*)
 
 var 
    x, y: float;
    respuesta: string;
    size: int;
 
 begin
   writeln('** Calcular la raíz cuadrada de 12 **');
   writeln('Entrar x (> 0): ');
   readln(respuesta);
   writeln('Fin');

   size := 1;

   respuesta := 'hola mundo' + respuesta;
   writeln(respuesta);


   if (size > 1) then 
   begin
       size := size + 1;
       size := 1;
   end
   else
   begin
       size := (1 + 4) * 5;
   end

   while(size > 1) do
   begin
        size := 1;
   end

   for i:=1 to 10 do
   begin
        i := i + 1;
   end
 
   case respuesta of
         'a': begin 
                  size := 1; 
              end
         'b': begin
                  x := y + x + 1.1;
                  size := 2;
                  x := 1.1;
              end
         else begin
                  x := 1.1;
              end
             
   end

 end.