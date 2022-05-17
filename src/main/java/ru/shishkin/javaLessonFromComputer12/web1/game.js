var x=600,y=100;
var napr=0;
var t;

function fkey(kod)
{
	//alert(kod);
	if (kod==37) napr=6;
	if (kod==38) napr=8;
	if (kod==39) napr=4;
	if (kod==40) napr=2;
	
}
function go()
{
	t=document.getElementById("im");
	window.setInterval(step,10);
	
}
function step()
{
	if (napr==6)
	{
		x--;
		
	}
	if (napr==2)
	{
		y++;
		
	}
	if (napr==4)
	{
		x++;
		
	}
	if (napr==8)
	{
		y--;
		
	}
	//x++;
	//y++;
	t.style.top=""+y+"px";
	t.style.left=""+x+"px";
	//t.style.width=""+y+"px";
	//t.style.height=""+x+"px";
}