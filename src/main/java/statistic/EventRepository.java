
package statistic;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "events", path = "events")
public interface EventRepository extends MongoRepository<Event, String> {

        //Поиск события по secret key
	List<Event> findBySecretKey(@Param("key") String key);
        
        //Поиск события по secret key и по имени события
        List<Event> findBySecretKeyAndEventName(@Param("key") String secretKey, @Param("name") String eventName);
}