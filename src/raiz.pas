program raiz(input:string; output:string);
 (*Obtener la raíz cuadrada de un número real x cualquiera.*)
 
 type 
        (* Type of the element array. *)
        IntArrType = int;
        IntArr = array[50] of int;
        sergio = record
                    tmp: int;
                    tmp2: string;
                    size:int;
                    ass:IntArr;
                 end;
        arrayprueba = array[5] of sergio;
 var 
    x, y: float;
    respuesta: string;
    size: int;
    test: IntArrType;
    test2: test;
    test_array: IntArr;

 function ReadArr():string;
 var
    c, d: int;
    supertext :string;
 begin
    supertext := input;
    c := arrayprueba[1].tmp;
 end;
 
 begin
   writeln('** Calcular la raíz cuadrada de 12 **');
   writeln('Entrar x (> 0): ');
   readln(respuesta);
   writeln('Fin');

   size := IntArr[1];

   size := sergio.tmp + 1 + sergio.size;

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
        test := 9;
   end
 
   case respuesta of
         'a': begin 
                  size := 1; 
                  test := size + 1 + test2;
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