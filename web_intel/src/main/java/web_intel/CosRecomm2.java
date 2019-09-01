package web_intel;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.UncenteredCosineSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class CosRecomm2 {
	public static void main(String[] args) {
		try {
			DataModel dm = new FileDataModel(new File("F://big data specialization doc/web intelligence/sample.csv"));
			UserSimilarity us = new UncenteredCosineSimilarity(dm);
			UserNeighborhood nh = new ThresholdUserNeighborhood(0.7, us, dm);
			Recommender r = new GenericUserBasedRecommender(dm, nh, us);
			for(LongPrimitiveIterator i = dm.getUserIDs();i.hasNext();) {
				long userId = i.nextLong();
				long[] friends = nh.getUserNeighborhood(userId);
				for(long j: friends) {
					double score = us.userSimilarity(userId, j);
					System.out.println(userId + " " + j + " " + score);
				}
				
			
			
			
			List<RecommendedItem> r1 = r.recommend(userId,1);
			for(RecommendedItem r2 : r1) {
				System.out.println(r2);
			}
			}
		} catch (TasteException ts) {
			System.out.println(ts);// TODO: handle exception
		}
		catch(IOException ie) {
			System.out.println(ie);
		}
}
	}
