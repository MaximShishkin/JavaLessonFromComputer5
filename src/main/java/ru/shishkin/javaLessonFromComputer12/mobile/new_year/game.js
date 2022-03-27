var x=400,y=500;
var napr=0;
var t,p;

function fkey(kod)
{
	//alert(kod);
	if (kod==37) napr=6;
	//if (kod==38) napr=8;
	if (kod==39) napr=4;
	if (kod==40) napr=2;
	
}
function go()
{
	t=document.getElementById("shapka");
	p=document.getElementById("podarok");
	window.setInterval(step,10);
	
}
function step()
{
	
	if (napr==6)
	{
		x-=6;
		
	}
	if (napr==4)
	{
		x+=6;
		
	}
	if (napr==2)
	{
		y+=6;
		
	}
	
	
	//x++;
	//y++;
	t.style.top=""+y+"px";
	t.style.left=""+x+"px";
	p.style.left=""+y+"px";
	
	//t.style.width=""+y+"px";
	//t.style.height=""+x+"px";
}