function odliczanie()
{
    var dzisiaj = new Date();
    
    var dzien = dzisiaj.getDate();
    var miesiac = dzisiaj.getMonth()+1;
    var rok = dzisiaj.getFullYear();

    var godzina = dzisiaj.getHours();
    if (godzina<10)godzina="0"+godzina;
    var minuta = dzisiaj.getMinutes();
    if (minuta<10) minuta="0"+minuta;
    var sekunda = dzisiaj.getSeconds();
    if (sekunda<10) sekunda="0"+sekunda;

     document.getElementById("timer").innerHTML = 
    dzien+"/"+miesiac+"/"+rok+" | "+godzina+":"+minuta+":"+sekunda;

    setTimeout("odliczanie()",1000);

}


var numer1 = Math.floor(Math.random()*5)+1;
var numer2 = Math.floor(Math.random()*4)+1;
var timer1 = 0;
var timer2 = 0;
var timer3 = 0;
var timer4 = 0;


function schowaj1()
        {
            $("#player").fadeOut(500);
        }
function schowaj2()
        {
            $("#team").fadeOut(500);
        }
function zmienslajd1()
        {
            numer1++; 
            if(numer1>5) numer1=1;
           
            var plik = "<img src=\"/images/player" + numer1 +".jpg\"  width=250px height=300px  />";

            document.getElementById("player").innerHTML = plik;
            $("#player").fadeIn(500)

          

            timer1 = setTimeout("zmienslajd1()", 5000);
            timer2 = setTimeout("schowaj1()", 4500);

        }

function zmienslajd2()
        {
            numer2++; 
            if(numer2>5) numer2=1;

            var plik = "<img src=\"/images/team" + numer2 +".jpg\" width=250px height=300px />";

            document.getElementById("team").innerHTML = plik;
            $("#team").fadeIn(500)

           

            timer3 = setTimeout("zmienslajd2()", 5000);
            timer4 = setTimeout("schowaj2()", 4500);

        }


    function start()
    {
        odliczanie();
        zmienslajd1();
        setTimeout("schowaj2()",2000);
        setTimeout("zmienslajd2()",2500);
        

    }