package web_intel;

import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;



public class Recommender1 {
	public static void main(String[] args) {
		try {
			DataModel dm = new FileDataModel(new File("F://big data specialization doc/web intelligence/ratings.csv"));
			UserSimilarity us = new PearsonCorrelationSimilarity(dm);
			UserNeighborhood un = new ThresholdUserNeighborhood(0.7, us, dm);
			Recommender r = new GenericUserBasedRecommender(dm, un, us);
			
			List<RecommendedItem> r1 = r.recommend(2,10);
			for(RecommendedItem r2 : r1) {
				System.out.println(r2);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
