package org.fazio.simsports.basketball.prep;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.query.Query;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Michael Fazio
 * @since 12/8/12 11:52 AM
 */
public class BRMongo {

	public static final String MONGO_URL = "127.0.0.1";
	public static final String MONGO_MAIN_DB = "BR-Data";

	protected static final Mongo mongo = BRMongo.getMongoInstance();
	protected static Datastore datastore;

	private static final BRMongo brMongo = new BRMongo();

	private BRMongo() {
		BRMongo.datastore = new Morphia().createDatastore(BRMongo.mongo, MONGO_MAIN_DB);
	}

	public static BRMongo getInstance() {
		return BRMongo.brMongo;
	}

	public static BRMongo getInstance(final boolean isTest) {
		BRMongo.brMongo.setIsTest(isTest);

		return BRMongo.brMongo;
	}

	private static Mongo getMongoInstance() {
		Mongo mongo = null;
		try {
			mongo = new Mongo(MONGO_URL);
		} catch(UnknownHostException e) {
			e.printStackTrace();
		}

		return mongo;
	}

	public <T> Key<T> save(final T saveObj) {
		return BRMongo.datastore.save(saveObj);
	}

	public <T> Iterable<Key<T>> saveAll(Iterable<T> saveList) {
		return BRMongo.datastore.save(saveList);
	}

	public <T> WriteResult delete(final T deleteObj) {
		return BRMongo.datastore.delete(deleteObj);
	}

	public <T> List<T> findAll(final Class<T> type) {
		final Query<T> findResult = BRMongo.datastore.find(type).order("name");

		return findResult != null ? findResult.asList() : new ArrayList<T>();
	}

	public <T> List<T> find(final Class<T> type, final String field, final Object criterion) {
		final List<Object> ruleList = new ArrayList<Object>() {{
			add(criterion);
		}};

		return this.find(type, new HashMap<String, List<Object>>() {{
			put(field, ruleList);
		}});
	}

	public <T> List<T> find(final Class<T> type, final Map<String, List<Object>> rules) {
		final Query<T> query = BRMongo.datastore.createQuery(type);

		for(Map.Entry<String, List<Object>> rule : rules.entrySet()) {
			query.field(rule.getKey()).in(rule.getValue());
		}

		return query.asList();
	}

	public <T> Query<T> createQuery(final Class<T> type) {
		return BRMongo.datastore.createQuery(type);
	}

	public void setIsTest(final boolean isTest) {
		BRMongo.datastore
			= new Morphia().createDatastore(BRMongo.mongo, MONGO_MAIN_DB);
	}
	
}
