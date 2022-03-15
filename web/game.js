var x=200, y=530;
var napr=0;
var t;
var act=false;
var podar;

function go()
{
	podar = new Array();
	for (var i=0; i<7; i++)
	{
		podar[i] = 
	}

	t = document.getElementById("im");
	window.setInterval(fkey, 10);
}

function fkey(kod)
{
	napr=kod;
	if (napr == 37)
	{
		x-=5;
		t.style.left = ""+x+"px";
	}
	if (napr == 39)
	{
		x+=5;
		t.style.left = ""+x+"px";
	}
	
	
}

function step()
{
	x++;
	t.style.left = ""+x+"px";	
}
