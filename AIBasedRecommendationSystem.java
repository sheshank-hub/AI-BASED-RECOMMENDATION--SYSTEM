package sheshiii;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import java.io.File;
import java.io.IOException;
import java.util.List;
public class AIBasedRecommendationSystem {
		    public static void main(String[] args) {
		        try {
		            DataModel model = new FileDataModel(new File("preferences.csv"));
		            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
		            UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
		            UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
		            List<RecommendedItem> recommendations = recommender.recommend(1, 4);
		            System.out.println("Recommended products for User 1:");
		            for (RecommendedItem recommendation : recommendations) {
		                System.out.println(recommendation);
		            }
		        } catch (IOException e) {
		            System.err.println("Error loading data: " + e.getMessage());
		        } catch (TasteException e) {
		            System.err.println("Recommendation error: " + e.getMessage());
		        }
		    }
		}
