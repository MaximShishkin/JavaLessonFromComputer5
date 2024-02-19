{contact_center_with_voice+data requests}
PROGRAM waitmono(INPUT,OUTPUT);

VAR
noc,w,v,i,k,j:longint;
sum,p_v,pg,sigma,lambda,lambda_v,lambda_f,alpha,p_f,p_r,pi_f,pi_v,pi_q,m,m_v,m_f,w_f,t_w:real;
p:array[0..15000] of real;
res:text;

BEGIN

{
 assign(res,'d:\test.txt');
 rewrite(res);





 values of input parameters and performance measures}

{
v - number of operators,
w - maximum number of waiting powitions,
lambda - intensity of requests,
lambda_v - intensity of voice requests,
lambda_f - intensity of data requests,
p_v - portion of voice requests,
p_f - portion of data requests,
p_r - the probability of continuation of servicing after IVR,
1/mu - mean value of service time,
1/sigma - mean value of restriction on maximum allowed waiting (aging) time
pi_v - the portion of lost voice requests,
pi_f - the portion of lost data requests,
pi_q  - the portion of requests entering queue
m_v - mean number of operators occupied by voice requests
m_f - mean number of operators occupied by data requests
m - mean number of occupied operators
t_w - mean waiting time for  requests  in queue
}


v:=5;
sigma:=2;
w:=5;
lambda:=5;
alpha:=4;
p_v:=0.8;
p_f:=0.2;
lambda_v:=lambda*p_v;
lambda_f:=lambda*p_f;
p_r:=0.8;

{noc - number of calculation cycles}

for noc:=1 to 1 do
begin

p[0]:=1;

for i:=0 to v-1 do
   p[i+1]:=p[i]*(lambda_v*p_r+lambda_f)/((i+1)*alpha);

for i:=v to v+w-1 do
   p[i+1]:=p[i]*lambda_f/(v*alpha+(i+1-v)*sigma);

sum:=0;
for i:=0 to v+w do
   sum:=sum+p[i];
for i:=0 to v+w do
   begin
     p[i]:=p[i]/sum;
      writeln(i:2,' ',p[i]:12:8);
   end;

pi_q:=0;pi_v:=0;pi_f:=0;m:=0;m_v:=0;m_f:=0;w_f:=0;t_w:=0;

for i:=0 to v+w do
 begin
    if(i<v) then m:=m+p[i]*i;
    if(i>=v) then
     begin
       w_f:=w_f+p[i]*(i-v);
       m:=m+p[i]*v;
     end;

    if((i>=v) and (pi_v>1e-10)) then pi_v:=pi_v+p[i];
    if((i>=v) and (i<v+w)) then pi_q:=pi_q+p[i];

 end;


   pi_f:=p[v+w]+sigma*w_f/lambda_f;
   m_v:=lambda_v*p_r/alpha;
   m_f:=m-m_v;
   t_w:=w_f/(lambda_f*pi_q);

   

 writeln('pi_v,pi_f,m,m_v,m_f,w_f,t_w=',pi_v:8:6,' ',pi_f:8:6,' ',m:8:6,' ',m_v:8:6,' ',m_f:8:6,' ',w_f:8:6,' ',t_w:8:6);
 
 end;
 {noc}


 END.{end of program reservationmono.pas}
