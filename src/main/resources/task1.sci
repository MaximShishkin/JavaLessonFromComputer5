xv = 4:1:14;
yv = [0.00232792,0.00951991,0.02607135,0.05457725,0.09478464,0.14417953,0.19936274,0.25714514,0.31504931,0.37137816,0.42508538];
xf = 20:2:40;
yf = [0.03259624, 0.04530567, 0.06078903, 0.07891071, 0.09937121, 0.12175690, 0.14559580, 0.17040795, 0.19574393, 0.22120926, 0.24647627];
y = [0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05];

subplot(1,2,1)
plot2d(xv,y,5)
plot2d(xv,yv,2)
xgrid();
xtitle("", "Intensity of coming requests, λ", "Ratio of lost voice requests, π_v");
legend("Required ratio of lost voice requests, 5%","Ratio of lost voice requests, π_v",2);
y_axes = gca();
y_axes.children.children(1).thickness = 2;
y_axes.children.children(2).thickness = 2;

subplot(1,2,2)
plot2d(xf,y,5)
plot2d(xf,yf,2)
xgrid();
xtitle("", "Intensity of coming requests, λ", "Ratio of lost file requests, π_f");
legend("Required ratio of lost voice requests, 5%","Ratio of lost  file requests, π_f",2);
y_axes = gca();
y_axes.children.children(1).thickness = 2;
y_axes.children.children(2).thickness = 2;
