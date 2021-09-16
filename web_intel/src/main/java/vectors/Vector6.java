package vectors;

import org.apache.mahout.math.DenseMatrix;
import org.apache.mahout.math.DenseVector;
import org.apache.mahout.math.Matrix;

public class Vector6 {
	
	public static void main(String[] args) {
		double[] v1 = {10,20,30,40};
		DenseVector d1 = new DenseVector(v1); 
		DenseMatrix temp = new DenseMatrix(4, 1);
		temp.assignColumn(0, d1);
		double[][] d2 = {{10,20,30,40},
				{111,222,333,444},
				{1,2,3,5},
				{2,3,6,8}};
		DenseMatrix dm1 = new DenseMatrix(d2);
		Matrix r = dm1.times(temp);
		System.out.println(r);
		
		 // TODO Auto-generated method stub

	}

}
