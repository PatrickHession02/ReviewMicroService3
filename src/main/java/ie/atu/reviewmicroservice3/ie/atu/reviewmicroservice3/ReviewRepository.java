package ie.atu.reviewmicroservice3.ie.atu.reviewmicroservice3;

import ie.atu.reviewmicroservice3.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}
