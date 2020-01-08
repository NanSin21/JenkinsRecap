package web_intel;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.apache.mahout.cf.taste.impl.common.FastByIDMap;
import org.apache.mahout.cf.taste.impl.model.GenericDataModel;
import org.apache.mahout.cf.taste.impl.model.GenericUserPreferenceArray;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.PreferenceArray;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class PrefRecomm3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FastByIDMap<PreferenceArray> fs = new FastByIDMap<>();
			PreferenceArray user1 = new GenericUserPreferenceArray(3);
			user1.setUserID(0, 1);
			user1.setItemID(0, 101);
			user1.setValue(0, 5.0f);
			user1.setItemID(1, 102);
			user1.setValue(1, 3.0f);
			user1.setItemID(2, 103);
			user1.setValue(2, 2.5f);
			
			PreferenceArray user2 = new GenericUserPreferenceArray(4);
			user2.setUserID(0, 2);
			user2.setItemID(0, 101);
			user2.setValue(0, 2.0f);
			user2.setItemID(1, 102);
			user2.setValue(1, 2.5f);
			user2.setItemID(2, 103);
			user2.setValue(2, 5.0f);
			user2.setItemID(3, 104);
			user2.setValue(3, 2.0f);
			
			PreferenceArray user3 = new GenericUserPreferenceArray(4);
			user3.setUserID(0, 3);
			user3.setItemID(0, 101);
			user3.setValue(0, 2.5f);
			user3.setItemID(1, 104);
			user3.setValue(1, 4.0f);
			user3.setItemID(2, 105);
			user3.setValue(2, 4.5f);
			user3.setItemID(3, 107);
			user3.setValue(3, 4.0f);
			
			PreferenceArray user4 = new GenericUserPreferenceArray(4);
			user4.setUserID(0, 4);
			user4.setItemID(0, 101);
			user4.setValue(0, 5.0f);
			user4.setItemID(1, 103);
			user4.setValue(1, 3.0f);
			user4.setItemID(2, 104);
			user4.setValue(2, 4.5f);
			user4.setItemID(3, 106);
			user4.setValue(3, 4.0f);
			
			PreferenceArray user5 = new GenericUserPreferenceArray(6);
			user5.setUserID(0, 5);
			user5.setItemID(0, 101);
			user5.setValue(0, 4.0f);
			user5.setItemID(1, 102);
			user5.setValue(1, 3.0f);
			user5.setItemID(2, 103);
			user5.setValue(2, 2.f);
			user5.setItemID(3, 104);
			user5.setValue(3, 4.0f);
			user5.setItemID(4, 105);
			user5.setValue(4, 3.5f);
			user5.setItemID(5, 106);
			user5.setValue(5, 4.0f);
			
			fs.put(1, user1);
			fs.put(2, user2);
			fs.put(3, user3);
			fs.put(4, user4);
			fs.put(5, user5);
			DataModel dm  = new GenericDataModel(fs);
			UserSimilarity us = new PearsonCorrelationSimilarity(dm);
			UserNeighborhood nh = new NearestNUserNeighborhood(2, us, dm);
			Recommender r = new GenericUserBasedRecommender(dm, nh, us);
			
			List<RecommendedItem> r1 = r.recommend(2,1);
			for(RecommendedItem r2 : r1) {
				System.out.println(r2);
			}
						
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
