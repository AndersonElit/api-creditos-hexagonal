package co.com.apicreditos.mongo.vinculacion.repository;

import co.com.apicreditos.mongo.vinculacion.document.VinculacionDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoVinculacionRepository extends ReactiveMongoRepository<VinculacionDocument, String>, ReactiveQueryByExampleExecutor<VinculacionDocument> {
}
