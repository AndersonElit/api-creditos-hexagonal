package co.com.apicreditos.mongo.repository;

import co.com.apicreditos.mongo.document.EventDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoEventRepository extends ReactiveMongoRepository<EventDocument, String> {
}
