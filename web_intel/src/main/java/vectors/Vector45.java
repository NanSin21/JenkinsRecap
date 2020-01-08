package vectors;

import org.apache.mahout.math.DenseVector;
import org.apache.mahout.math.function.DoubleDoubleFunction;
import org.apache.mahout.math.function.DoubleFunction;

public class Vector45 {
	public static double[] v1 = {10,20,30,40};
	public static void main(String[] args) {
		
		
		DenseVector d1 = new DenseVector(v1);
		 DoubleFunction df = new DoubleFunction() {
			
			@Override
			public double apply(double a) {
				// TODO Auto-generated method stub
				return a*a;
			}
		};

		DoubleDoubleFunction df2 = new DoubleDoubleFunction() {
			
			@Override
			public double apply(double sum, double b) {
				// TODO Auto-generated method stub
				return (sum+b);
			}
			
		};
		 double r = d1.aggregate(df2, df);
		 System.out.println(r);
		
// TODO Auto-generated method stub

	}

}
