xv = 20:1:25;
yv = [0.00940897, 0.02188757, 0.03807420, 0.05865347, 0.08434525, 0.11589269];
xf = 58:1:63;
yf = [0.04633528,0.04804419,0.04976193,0.05148845,0.05322375,0.05496789];
y = [0.05,0.05,0.05,0.05,0.05,0.05];

subplot(1,2,1)
plot2d(xv,y,5)
plot2d(xv,yv,2)
xgrid();
xtitle("Dependence of the ratio of lost voice requests on the intensity of incoming requests", "Intensity of coming requests, λ", "Ratio of lost voice requests, π ");
legend("Ratio of lost voice requests, 5%","Intensity of coming requests",2);
y_axes = gca();
y_axes.children.children(1).thickness = 2;
y_axes.children.children(2).thickness = 2;

subplot(1,2,2)
plot2d(xf,y,5)
plot2d(xf,yf,2)
xgrid();
xtitle("Dependence of the ratio of lost  file requests on the intensity of incoming requests", "Intensity of coming requests, λ", "Ratio of lost file requests, π ");
legend("Ratio of lost  file requests, 5%","Intensity of coming requests",2);
y_axes = gca();
y_axes.children.children(1).thickness = 2;
y_axes.children.children(2).thickness = 2;
