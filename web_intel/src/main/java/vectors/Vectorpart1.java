package vectors;

import org.apache.mahout.math.DenseVector;
import org.apache.mahout.math.Vector;
import org.apache.mahout.math.function.DoubleDoubleFunction;

public class Vectorpart1 {
 
	public static void main(String[] args) {
		double[] v1 = {10,20,30,40};
		double[] v2 = {10,20,30,40};
		DenseVector d1 = new DenseVector(v1);
		DenseVector d2 = new DenseVector( v2);

		DoubleDoubleFunction dd = new DoubleDoubleFunction() {

		@Override
		public double apply(double a, double b) {

		return ((a*3)-b);
		}
		};


		Vector r =  d1.assign(d2,dd);
		System.out.println(r);


	}

}
