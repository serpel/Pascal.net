(*****************************************************************************
 * A simple bubble sort program.  Reads integers, one per line, and prints   *
 * them out in sorted order.  Blows up if there are more than 49.            *
 *****************************************************************************)
program Sort(input, output);
    type 
        (* Type of the element array. *)
        IntArrType = array[50] of int;

        (* Register *)
        alumnos = record 
                    name :string;
                    id :int;
                    edad :int;
                  end;

    var
        (* Indexes, exchange temp, array size. *)
        i, j, tmp, size: int;

        (* Array of ints *)
        arr: IntArrType;

        test: array[50] of alumnos;


    (* Read in the integers. *)
    function ReadArr(var size: Integer; var a: IntArrType; var flag: bool):string;
    begin
            flag := true;
            size := 1;
            while (eof > 1) do 
            begin
                readln(a);
                writeln(a[0]);
                if (eof > 1) then 
                begin
                    size := size + 1;
                end
                else
                begin
                    size := 1;
                end
            end
    end;

   function readAlumnos(var al: test):string;
    begin
         al.id := 234;
         al[1] := 'sdsd';
    end;

    begin
        (* Read *)
        ReadArr(size, arr);
   
        (* Sort using bubble sort. *)
        for i := size - 1 to 1 do
        begin
            for j := 1 to i do
            begin
                if ( (test > ((5 + 3)* 4)/34) !=  1 ) then
                begin
                   test := 2;
                end
                else 
                begin
                   test := 1;
               end
            end
        end 
    end .