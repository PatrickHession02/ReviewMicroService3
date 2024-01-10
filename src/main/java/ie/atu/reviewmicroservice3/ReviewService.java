package ie.atu.reviewmicroservice3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String songID){
        // Create a new review
        Review review = reviewRepository.insert(new Review(reviewBody));

        // Update the corresponding Song document to include the new review reference
        mongoTemplate.update(Song.class)
                .matching(Criteria.where("songID").is(songID))
                .apply(new Update().push("reviewIds").value(review.getId()))
                .first();

        return review;
    }
}
