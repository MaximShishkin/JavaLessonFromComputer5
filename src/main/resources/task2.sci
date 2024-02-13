xv = 7:1:12;
yv = [0.27487561,0.18729328,0.12000427,0.07195197,0.04023974,0.02096427];
xf = 3:1:8;
yf = [0.23332770,0.14546080,0.09119263,0.05671042,0.03451504,0.020309409];
y = [0.05,0.05,0.05,0.05,0.05,0.05];

subplot(1,2,1)
plot2d(xv,y,5)
plot2d(xv,yv,2)
xgrid();
xtitle("Dependence of the ratio of lost voice requests on the intensity of incoming requests", "Number of operators, υ", "Ratio of lost voice requests, π");
legend("Ratio of lost voice requests, 5%","Number of operators",2);
y_axes = gca();
y_axes.children.children(1).thickness = 2;
y_axes.children.children(2).thickness = 2;

subplot(1,2,2)
plot2d(xf,y,5)
plot2d(xf,yf,2)
xgrid();
xtitle("Dependence of the ratio of lost file requests on the intensity of incoming requests", "Number of operators, υ", "Ratio of lost file requests, π");
legend("Ratio of lost file requests, 5%","Number of operators",2);
y_axes = gca();
y_axes.children.children(1).thickness = 2;
y_axes.children.children(2).thickness = 2;
