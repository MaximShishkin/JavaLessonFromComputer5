package ru.shishkin.maxim.contactCenter;

public class StartCalculation {
    public StartCalculation() {
        calc();
    }

    private boolean calc() {
        double lambda, qp, qr, a, a1, a2, mu, mu1, mu2, c, c1, c2;
        double sigma, sigma1, sigma2, h, nu;
        double lp, rp, lpt, rpt, ncc, ncp, dif, dif1, dif2, dif3, dif4, tol, delta;
        double mi, mi1, mi2, mit, mw, mw1, mw2, mwt, mr, mrp, q, sum, sum1, x1, x2;
        double pt, pt1, pt2, pc, pc1, pc2, pct, rb, rb1, rb2, rt, rt1, rt2, tw, tw1, tw2, twt, rb11, rb22;
        int z1, z2, z3, z4, z5, z6, nov, noi, j, rm, n, v, v1, v2, w, w1, w2, m, i, i1, i2;
        double[][][][] p = new double[80][80][80][80];
        double[][] ar = new double[100][100];
        double[] nui = new double[100];
        double[] ai = new double[100];

        // {values of input parameters}
        lambda = 12;
        qp = 0.8;
        qr = 0.0;
        a1 = 0.33;
        a2 = 0.33;
        a = 1 - a1 - a2;
        h = 0.8;
        nu = 0;
        rm = 0;
        mu = 3;
        mu1 = 3;
        mu2 = 3;
        c = 0.2;
        c1 = 0.5;
        c2 = 0.5;
        sigma = 0.3;
        sigma1 = 0.25;
        sigma2 = 0.25;
        v = 1;
        w = 1;
        v1 = 1;
        w1 = 1;
        v2 = 1;
        w2 = 1;

        // {nov - number of calculation variants}
        for (nov = 1; nov <= 1; nov++) {
            tol = 1e-12;
            //{started values for probabilities in iteration scheme}
            sum = 0;

            for (j = 0; j <= rm; j++) {
                for (i = 0; i <= v + w; i++) {
                    for (i1 = 0; i1 <= v1 + w1; i1++) {
                        for (i2 = 0; i2 <= v2 + w2; i2++) {
                            p[j][i][i1][i2] = 1;
                        }
                    }
                }
            }

            //{started values for parameters of iteration process}
            noi = 0;
            ncc = 1;

            //{beginning of iteration scheme  }
            do {
                ncp = ncc;
                ncc = 0;      // {lpt:=0;rpt:=0;}

                //{forming system of state equation}
                for (j = 0; j <= rm; j++) {
                    for (i = 0; i <= v + w; i++) {
                        for (i1 = 0; i1 <= v1 + w1; i1++) {
                            for (i2 = 0; i2 <= v2 + w2; i2++) {
                                //{coefficient for p(j,i,i1,i2) in left part system of state equation}
                                lp = 0;

                                //{exeptance of  a coming primary call}
                                if (i < v + w) lp = lp + lambda * qp * a;
                                if (i1 < v1 + w1) lp = lp + lambda * qp * a1;
                                if (i2 < v2 + w2) lp = lp + lambda * qp * a2;

                                // {exeptance of  a coming repeated call}
                                if (i < v + w) lp = lp + j * nu * qr * a;
                                if (i1 < v1 + w1) lp = lp + j * nu * qr * a1;
                                if (i2 < v2 + w2) lp = lp + j * nu * qr * a2;

                                // {blocking and subsequent repeatition}
                                if ((i == v + w) && (j < rm)) lp = lp + lambda * h * qp * a;
                                if ((i1 == v1 + w1) && (j < rm)) lp = lp + lambda * h * qp * a1;
                                if ((i2 == v2 + w2) && (j < rm)) lp = lp + lambda * h * qp * a2;

                                //{blocking and subsequent stopping of  repeatition}
                                if (i == v + w) lp = lp + j * nu * (1 - h) * qr * a;
                                if (i1 == v1 + w1) lp = lp + j * nu * (1 - h) * qr * a1;
                                if (i2 == v2 + w2) lp = lp + j * nu * (1 - h) * qr * a2;

                                // {serving by IVR of  repeated attempt}
                                lp = lp + j * nu * (1 - qr);

                                //{serving by operator or cons.}
                                if (i <= v) lp = lp + i * mu;
                                if (i > v) lp = lp + v * mu;
                                if (i1 <= v1) lp = lp + i1 * mu1;
                                if (i1 > v1) lp = lp + v1 * mu1;
                                if (i2 <= v2) lp = lp + i2 * mu2;
                                if (i2 > v2) lp = lp + v2 * mu2;

                                // {leaving of the waiting positions}
                                if (i > v) lp = lp + (i - v) * sigma;
                                if (i1 > v1) lp = lp + (i1 - v1) * sigma1;
                                if (i2 > v2) lp = lp + (i2 - v2) * sigma2;

                                //{construction of right part system of state equation: for state (j,i,i1,i2)}
                                rp = 0;

                                //  {exeptance of  a coming primary call}
                                if (i > 0) rp = rp + p[j][i - 1][i1][i2] * lambda * qp * a;
                                if (i1 > 0) rp = rp + p[j][i][i1 - 1][i2] * lambda * qp * a1;
                                if (i2 > 0) rp = rp + p[j][i][i1][i2 - 1] * lambda * qp * a2;

                                // {exeptance of  a coming repeated call}
                                if ((i > 0) && (j < rm)) rp = rp + p[j + 1][i - 1][i1][i2] * (j + 1) * nu * qr * a;
                                if ((i1 > 0) && (j < rm)) rp = rp + p[j + 1][i][i1 - 1][i2] * (j + 1) * nu * qr * a1;
                                if ((i2 > 0) && (j < rm)) rp = rp + p[j + 1][i][i1][i2 - 1] * (j + 1) * nu * qr * a2;

                                //  {blocking and subsequent repeatition}
                                if ((i == v + w) && (j > 0)) rp = rp + p[j - 1][i][i1][i2] * lambda * h * qp * a;
                                if ((i1 == v1 + w1) && (j > 0)) rp = rp + p[j - 1][i][i1][i2] * lambda * h * qp * a1;
                                if ((i2 == v2 + w2) && (j > 0)) rp = rp + p[j - 1][i][i1][i2] * lambda * h * qp * a2;

                                //  {blocking and subsequent stopping of  repeatition}
                                if ((i == v + w) && (j < rm))
                                    rp = rp + p[j + 1][i][i1][i2] * (j + 1) * nu * (1 - h) * qr * a;
                                if ((i1 == v1 + w1) && (j < rm))
                                    rp = rp + p[j + 1][i][i1][i2] * (j + 1) * nu * (1 - h) * qr * a1;
                                if ((i2 == v2 + w2) && (j < rm))
                                    rp = rp + p[j + 1][i][i1][i2] * (j + 1) * nu * (1 - h) * qr * a2;

                                //  {serving by IVR of  repeated attempt}
                                if (j < rm) rp = rp + p[j + 1][i][i1][i2] * (j + 1) * nu * (1 - qr);

                                //  {serving by operator}
                                if (i + 1 <= v) rp = rp + p[j][i + 1][i1][i2] * (i + 1) * mu * (1 - c);
                                if ((i + 1 <= v + w) && (i + 1 > v)) rp = rp + p[j][i + 1][i1][i2] * v * mu * (1 - c);

                                //   {transition to the first group}
                                if ((i + 1 <= v) && (i1 > 0)) rp = rp + p[j][i + 1][i1 - 1][i2] * (i + 1) * mu * c * c1;
                                if ((i + 1 <= v) && (i1 == v1 + w1) && (j < rm))
                                    rp = rp + p[j][i + 1][i1][i2] * (i + 1) * mu * c * c1 * (1 - h);
                                if ((i + 1 <= v) && (i1 == v1 + w1) && (j == rm))
                                    rp = rp + p[j][i + 1][i1][i2] * (i + 1) * mu * c * c1;
                                if ((i + 1 <= v) && (i1 == v1 + w1) && (j > 0))
                                    rp = rp + p[j - 1][i + 1][i1][i2] * (i + 1) * mu * c * c1 * h;
                                if ((i + 1 <= v + w) && (i + 1 > v) && (i1 > 0))
                                    rp = rp + p[j][i + 1][i1 - 1][i2] * v * mu * c * c1;
                                if ((i + 1 <= v + w) && (i + 1 > v) && (i1 == v1 + w1) && (j < rm))
                                    rp = rp + p[j][i + 1][i1][i2] * v * mu * c * c1 * (1 - h);
                                if ((i + 1 <= v + w) && (i + 1 > v) && (i1 == v1 + w1) && (j == rm))
                                    rp = rp + p[j][i + 1][i1][i2] * v * mu * c * c1;
                                if ((i + 1 <= v + w) && (i + 1 > v) && (i1 == v1 + w1) && (j > 0))
                                    rp = rp + p[j - 1][i + 1][i1][i2] * v * mu * c * c1 * h;

                                //   {transition to the second group}
                                if ((i + 1 <= v) && (i2 > 0)) rp = rp + p[j][i + 1][i1][i2 - 1] * (i + 1) * mu * c * c2;
                                if ((i + 1 <= v) && (i2 == v2 + w2) && (j < rm))
                                    rp = rp + p[j][i + 1][i1][i2] * (i + 1) * mu * c * c2 * (1 - h);
                                if ((i + 1 <= v) && (i2 == v2 + w2) && (j == rm))
                                    rp = rp + p[j][i + 1][i1][i2] * (i + 1) * mu * c * c2;
                                if ((i + 1 <= v) && (i2 == v2 + w2) && (j > 0))
                                    rp = rp + p[j - 1][i + 1][i1][i2] * (i + 1) * mu * c * c2 * h;
                                if ((i + 1 <= v + w) && (i + 1 > v) && (i2 > 0))
                                    rp = rp + p[j][i + 1][i1][i2 - 1] * v * mu * c * c2;
                                if ((i + 1 <= v + w) && (i + 1 > v) && (i2 == v2 + w2) && (j < rm))
                                    rp = rp + p[j][i + 1][i1][i2] * v * mu * c * c2 * (1 - h);
                                if ((i + 1 <= v + w) && (i + 1 > v) && (i2 == v2 + w2) && (j == rm))
                                    rp = rp + p[j][i + 1][i1][i2] * v * mu * c * c2;
                                if ((i + 1 <= v + w) && (i + 1 > v) && (i2 == v2 + w2) && (j > 0))
                                    rp = rp + p[j - 1][i + 1][i1][i2] * v * mu * c * c2 * h;

                                //     {serving by consultant}
                                if (i1 + 1 <= v1) rp = rp + p[j][i][i1 + 1][i2] * (i1 + 1) * mu1;
                                if (i2 + 1 <= v2) rp = rp + p[j][i][i1][i2 + 1] * (i2 + 1) * mu2;
                                if ((i1 + 1 <= v1 + w1) && (i1 + 1 > v1)) rp = rp + p[j][i][i1 + 1][i2] * v1 * mu1;
                                if ((i2 + 1 <= v2 + w2) && (i2 + 1 > v2)) rp = rp + p[j][i][i1][i2 + 1] * v2 * mu2;

                                //      {leaving of the waiting positions out of c-c or to repeatiton}
                                if ((i + 1 <= v + w) && (i + 1 > v) && (j < rm))
                                    rp = rp + p[j][i + 1][i1][i2] * (i + 1 - v) * sigma * (1 - h);
                                if ((i + 1 <= v + w) && (i + 1 > v) && (j == rm))
                                    rp = rp + p[j][i + 1][i1][i2] * (i + 1 - v) * sigma;
                                if ((i + 1 <= v + w) && (i + 1 > v) && (j > 0))
                                    rp = rp + p[j - 1][i + 1][i1][i2] * (i + 1 - v) * sigma * h;

                                if ((i1 + 1 <= v1 + w1) && (i1 + 1 > v1) && (j < rm))
                                    rp = rp + p[j][i][i1 + 1][i2] * (i1 + 1 - v1) * sigma1 * (1 - h);
                                if ((i1 + 1 <= v1 + w1) && (i1 + 1 > v1) && (j == rm))
                                    rp = rp + p[j][i][i1 + 1][i2] * (i1 + 1 - v1) * sigma1;
                                if ((i1 + 1 <= v1 + w1) && (i1 + 1 > v1) && (j > 0))
                                    rp = rp + p[j - 1][i][i1 + 1][i2] * (i1 + 1 - v1) * sigma1 * h;

                                if ((i2 + 1 <= v2 + w2) && (i2 + 1 > v2) && (j < rm))
                                    rp = rp + p[j][i][i1][i2 + 1] * (i2 + 1 - v2) * sigma2 * (1 - h);
                                if ((i2 + 1 <= v2 + w2) && (i2 + 1 > v2) && (j == rm))
                                    rp = rp + p[j][i][i1][i2 + 1] * (i2 + 1 - v2) * sigma2;
                                if ((i2 + 1 <= v2 + w2) && (i2 + 1 > v2) && (j > 0))
                                    rp = rp + p[j - 1][i][i1][i2 + 1] * (i2 + 1 - v2) * sigma2 * h;

                                //    {calculation of the next step of iteration process}
                                p[j][i][i1][i2] = rp / lp;    // { lpt:=lpt+lp; rpt:=rpt+rp;}

                                //    {calculation of normalizing condition}
                                ncc = ncc + p[j][i][i1][i2];
                            }
                        }
                    }
                }  // {cykle of j,i,i1,i2}

                //{calculation of current number of iteration step}
                noi = noi + 1;

                // {checking the validity of the system of state equation construction}
                //{calculation of normalized differencebetween successive sum of probabilities}
                dif = Math.abs(ncc - ncp) / ncc;
		/*if(noi % 100==0)
		{
			//System.out.println("number of iteration="+noi+"norm.  difference="+dif);
		}
		//  writeln('number of iteration=',noi:4,' ','norm.  difference=',dif:12);
		 */
                // {checking of tolerence condition}
            }
            while ((dif >= tol) || (noi <= 900));

            System.out.println("iteration process finished");

            // {normalization of state probabilities}
            for (j = 0; j <= rm; j++) {
                for (i = 0; i <= v + w; i++) {
                    for (i1 = 0; i1 <= v1 + w1; i1++) {
                        for (i2 = 0; i2 <= v2 + w2; i2++) {
                            p[j][i][i1][i2] = p[j][i][i1][i2] / ncc;
                        }
                    }
                }
            }

            //{calculation of mean values of model's parameters presented as state components}
            mi = 0;
            mi1 = 0;
            mi2 = 0;
            mw = 0;
            mw1 = 0;
            mw2 = 0;
            mr = 0;

            for (j = 0; j <= rm; j++) {
                for (i = 0; i <= v + w; i++) {
                    for (i1 = 0; i1 <= v1 + w1; i1++) {
                        for (i2 = 0; i2 <= v2 + w2; i2++) {
                            if (i <= v) mi = mi + p[j][i][i1][i2] * i;
                            if (i > v) mi = mi + p[j][i][i1][i2] * v;
                            if (i > v) mw = mw + p[j][i][i1][i2] * (i - v);
                            if (i1 <= v1) mi1 = mi1 + p[j][i][i1][i2] * i1;
                            if (i1 > v1) mi1 = mi1 + p[j][i][i1][i2] * v1;
                            if (i1 > v1) mw1 = mw1 + p[j][i][i1][i2] * (i1 - v1);
                            if (i2 <= v2) mi2 = mi2 + p[j][i][i1][i2] * i2;
                            if (i2 > v2) mi2 = mi2 + p[j][i][i1][i2] * v2;
                            if (i2 > v2) mw2 = mw2 + p[j][i][i1][i2] * (i2 - v2);
                            mr = mr + p[j][i][i1][i2] * j;
                        }
                    }
                }
            }

            //{probablities of resource occupation (pt) on phases of servicing}
            pt = 0;
            pt1 = 0;
            pt2 = 0;

            for (j = 0; j <= rm; j++) {
                for (i = 0; i <= v + w; i++) {
                    for (i1 = 0; i1 <= v1 + w1; i1++) {
                        for (i2 = 0; i2 <= v2 + w2; i2++) {
                            if (i == v + w) pt = pt + p[j][i][i1][i2];
                            if (i1 == v1 + w1) pt1 = pt1 + p[j][i][i1][i2];
                            if (i2 == v2 + w2) pt2 = pt2 + p[j][i][i1][i2];
                        }
                    }
                }
            }

            //{intensities of blocked  (rb)  and coming (rt) calls on phases of servicing}
            rb = 0;
            rb1 = 0;
            rb2 = 0;
            rb11 = 0;
            rb22 = 0;
            rt = 0;
            rt1 = 0;
            rt2 = 0;

            for (j = 0; j <= rm; j++) {
                for (i = 0; i <= v + w; i++) {
                    for (i1 = 0; i1 <= v1 + w1; i1++) {
                        for (i2 = 0; i2 <= v2 + w2; i2++) {
                            if (i == v + w) rb = rb + p[j][i][i1][i2] * (lambda * qp + j * nu * qr) * a;
                            rt = rt + p[j][i][i1][i2] * (lambda * qp + j * nu * qr) * a;

                            if (i1 == v1 + w1) rb1 = rb1 + p[j][i][i1][i2] * (lambda * qp + j * nu * qr) * a1;
                            if (i1 == v1 + w1) rb11 = rb11 + p[j][i][i1][i2] * (lambda * qp + j * nu * qr) * a1;

                            if ((i <= v) && (i1 == v1 + w1)) rb1 = rb1 + p[j][i][i1][i2] * i * mu * c * c1;
                            if ((i > v) && (i1 == v1 + w1)) rb1 = rb1 + p[j][i][i1][i2] * v * mu * c * c1;
                            rt1 = rt1 + p[j][i][i1][i2] * (lambda * qp + j * nu * qr) * a1;
                            if (i <= v) rt1 = rt1 + p[j][i][i1][i2] * i * mu * c * c1;
                            if (i > v) rt1 = rt1 + p[j][i][i1][i2] * v * mu * c * c1;

                            if (i2 == v2 + w2) rb2 = rb2 + p[j][i][i1][i2] * (lambda * qp + j * nu * qr) * a2;
                            if (i2 == v2 + w2) rb22 = rb22 + p[j][i][i1][i2] * (lambda * qp + j * nu * qr) * a2;

                            if ((i <= v) && (i2 == v2 + w2)) rb2 = rb2 + p[j][i][i1][i2] * i * mu * c * c2;
                            if ((i > v) && (i2 == v2 + w2)) rb2 = rb2 + p[j][i][i1][i2] * v * mu * c * c2;
                            rt2 = rt2 + p[j][i][i1][i2] * (lambda * qp + j * nu * qr) * a2;
                            if (i <= v) rt2 = rt2 + p[j][i][i1][i2] * i * mu * c * c2;
                            if (i > v) rt2 = rt2 + p[j][i][i1][i2] * v * mu * c * c2;

                        }
                    }
                }
            }

            delta = 0;

            //{delta keeps intensity of losses due to finite nature of rm}
            for (j = 0; j <= rm; j++) {
                for (i = 0; i <= v + w; i++) {
                    for (i1 = 0; i1 <= v1 + w1; i1++) {
                        for (i2 = 0; i2 <= v2 + w2; i2++) {
                            if ((i == v + w) && (j == rm)) delta = delta + p[j][i][i1][i2] * lambda * h * qp * a;
                            if ((i1 == v1 + w1) && (j == rm)) delta = delta + p[j][i][i1][i2] * lambda * h * qp * a1;
                            if ((i2 == v2 + w2) && (j == rm)) delta = delta + p[j][i][i1][i2] * lambda * h * qp * a2;

                            if ((i + 1 <= v) && (i1 == v1 + w1) && (j == rm))
                                delta = delta + p[j][i][i1][i2] * (i + 1) * mu * c * c1 * h;
                            if ((i + 1 <= v + w) && (i + 1 > v) && (i1 == v1 + w1) && (j == rm))
                                delta = delta + p[j][i][i1][i2] * v * mu * c * c1 * h;

                            if ((i + 1 <= v) && (i2 == v2 + w2) && (j == rm))
                                delta = delta + p[j][i][i1][i2] * (i + 1) * mu * c * c2 * h;
                            if ((i + 1 <= v + w) && (i + 1 > v) && (i2 == v2 + w2) && (j == rm))
                                delta = delta + p[j][i][i1][i2] * v * mu * c * c2 * h;

                            if ((i + 1 <= v + w) && (i + 1 > v) && (j == rm))
                                delta = delta + p[j][i][i1][i2] * (i + 1 - v) * sigma * h;

                            if ((i1 + 1 <= v1 + w1) && (i1 + 1 > v1) && (j == rm))
                                delta = delta + p[j][i][i1][i2] * (i1 + 1 - v1) * sigma1 * h;
                            if ((i2 + 1 <= v2 + w2) && (i2 + 1 > v2) && (j == rm))
                                delta = delta + p[j][i][i1][i2] * (i2 + 1 - v2) * sigma2 * h;
                        }
                    }
                }
            }

            //   {the ratio of blocked calls (pc) on phases of servicing}
            pc = (rb + mw * sigma) / rt;
            pc1 = (rb1 + mw1 * sigma1) / rt1;
            pc2 = (rb2 + mw2 * sigma2) / rt2;

            //  {the mean time of waiting or servicing (tw) on phases of servicing}
            tw = (mi + mw) / (rt - rb);
            tw1 = (mi1 + mw1) / (rt1 - rb1);
            tw2 = (mi2 + mw2) / (rt2 - rb2);

            //   {global measures of calls servicing}
            pct = (rb + mw * sigma + rb1 + mw1 * sigma1 + rb2 + mw2 * sigma2) / (lambda * qp + mr * nu * qr);
            twt = (mi + mw + mi1 + mw1 + mi2 + mw2) / (lambda * qp + mr * nu * qr - rb - rb11 - rb22);
            mwt = mw + mw1 + mw2;
            mit = mi + mi1 + mi2;
            mrp = mr * nu / lambda;
            q = (rb + mw * sigma + rb1 + mw1 * sigma1 + rb2 + mw2 * sigma2) / (mi * mu * (1 - c) + mi1 * mu1 + mi2 * mu2);

            //   {checking of the validity of relations based on Little formula for each component of the state vector
            //   (it is supposed that rm finite if not then delta=0)}
            dif = mr * nu - (rb + mw * sigma) * h - (rb1 + mw1 * sigma1) * h - (rb2 + mw2 * sigma2) * h;
            dif1 = mr * nu - (rb + mw * sigma) * h - (rb1 + mw1 * sigma1) * h - (rb2 + mw2 * sigma2) * h + delta;
            dif2 = rt - rb - mw * sigma - mi * mu;
            dif3 = rt1 - rb1 - mw1 * sigma1 - mi1 * mu1;
            dif4 = rt2 - rb2 - mw2 * sigma2 - mi2 * mu2;

            System.out.println("���� ������������� �������� =" + pct);
            System.out.println("������� ����� ������������ � �������=" + twt);
            //System.out.println(""+mwt);
            System.out.println("������� ���������� �������� �� ������������ =" + mit);
            System.out.println("���� ���������� ��������, ���������� �� ����������" + pc);
            System.out.println("C������ ���������� ������� ���������� = " + mi);
            System.out.println("������� ����� ���������� � �������, ��������� " + tw);

            System.out.println("���� ������������� ��������, 1= " + pc1);
            System.out.println("������� ����� ���������� � �������, 1 =" + tw1);
            //System.out.println("mw1="+mw1);
            System.out.println("������� ���������� �������, 1 = " + mi1);

            System.out.println("���� ������������� ��������, 2= " + pc2);
            System.out.println("������� ����� ���������� � �������, 2 = " + tw2);
            //System.out.println("mw2="+mw2);
            System.out.println("������� ���������� �������, 2 = " + mi2);

            // System.out.println("mr="+mr);
            // System.out.println("mrp="+(mr*nu/lambda));
            // System.out.println("nu="+nu);
            // System.out.println("Int="+(lambda+mr*nu));
            //System.out.println("pct="+pct);
            // System.out.println("pc="+pc);
            // System.out.println("pc1="+pc1);
            // System.out.println("pc2="+pc2);
            // System.out.println("twt="+twt);
            // System.out.println("mr="+mr);
            // System.out.println("mrp="+mrp);
            // System.out.println("q="+q);
            // System.out.println("delta="+delta);
            // System.out.println("rm="+rm);
        }
        return true;
    }
}
