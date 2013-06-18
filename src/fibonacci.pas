program raiz();
 (*Obtener la raíz cuadrada de un número real x cualquiera.*)
 
type
   alumnos = record
                 nombre: string;
                 edad: int;
             end;
   var 
        result,term1,term2,i :int;

function fibonacii(numero:int):int;
begin
    while i < numero do
    begin
        result := term1 + term2;
        writeln("resultado: ");
        writeln(result);
        term1 := term2;
        term2 := result;
        i := i + 1;   
    end
 
end;

   begin

   i := fibonacii(10);

   readln(i);

 end.