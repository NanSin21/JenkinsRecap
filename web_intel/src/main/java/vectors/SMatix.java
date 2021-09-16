package vectors;

import org.apache.mahout.cf.taste.impl.recommender.svd.Factorization;
import org.apache.mahout.cf.taste.impl.recommender.svd.SVDPlusPlusFactorizer;
import org.apache.mahout.cf.taste.impl.recommender.svd.SVDRecommender;
import org.apache.mahout.cf.taste.model.*;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.math.DenseMatrix;

public class SMatix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DataModel dm=new FileDataModel(new File( "F://big data specialization doc/web intelligence/ratings3.csv"));
			SVDPlusPlusFactorizer s1= new SVDPlusPlusFactorizer(dm,0,5);
			Factorization f1=s1.factorize();
			DenseMatrix d1 = new DenseMatrix(f1.allUserFeatures());
			DenseMatrix d2 = new DenseMatrix(f1.allItemFeatures());
			int Feat=f1.numFeatures();
			System.out.println("Number of features :"+Feat);
			System.out.println("User concept matrix:"+d1);
			System.out.println("item concept matrix:"+d2);

			Recommender r = new SVDRecommender(dm, s1);
			List<RecommendedItem> recc=r.recommend(15,3);
			for(RecommendedItem p:recc) {
			System.out.println("Recommende item :"+p.getItemID()+"\tvalue:"+p.getValue());
			}
		} catch (Exception e) {
			System.out.println(e);// TODO: handle exception
		}
	}

}
