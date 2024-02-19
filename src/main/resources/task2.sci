xv = 10:1:18;
yv = [0.31504931, 0.24088400, 0.17779024, 0.12618024, 0.08580254, 0.05573584, 0.03451058, 0.02034312, 0.01141275];
xf = 1:1:9;
yf = [0.72296678, 0.46204756, 0.25991500, 0.13700552, 0.07269653, 0.04031474, 0.02353521, 0.01434574, 0.00900675];
y = [0.05,0.05,0.05,0.05,0.05,0.05,0.05,0.05,0.05];

subplot(1,2,1)
plot2d(xv,y,5)
plot2d(xv,yv,2)
xgrid();
xtitle("", "Number of operators, υ", "Ratio of lost voice requests, π_v");
legend("Ratio of lost voice requests, 5%","Ratio of lost voice requests, π_v",2);
y_axes = gca();
y_axes.children.children(1).thickness = 2;
y_axes.children.children(2).thickness = 2;

subplot(1,2,2)
plot2d(xf,y,5)
plot2d(xf,yf,2)
xgrid();
xtitle("", "Number of operators, υ", "Ratio of lost file requests, π_f");
legend("Ratio of lost file requests, 5%","Ratio of lost file requests, π_f",2);
y_axes = gca();
y_axes.children.children(1).thickness = 2;
y_axes.children.children(2).thickness = 2;
