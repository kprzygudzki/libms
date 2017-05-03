package pl.przygudzki.libms.infrastructure;

import org.springframework.stereotype.Component;
import pl.przygudzki.libms.application.DbCleaner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class JPADbCleaner implements DbCleaner {

	private static final String QUERY_TABLES = "select table_name " +
			"from INFORMATION_SCHEMA.system_tables " +
			"where table_type='TABLE' " +
			"and table_schem='PUBLIC'";
	private static final String TABLE_DELETE = "DELETE FROM %s";

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void clean() {
		Query query = entityManager.createNativeQuery(QUERY_TABLES);
		List<String> tables = query.getResultList();
		for (String table : tables)
			entityManager.createNativeQuery(String.format(TABLE_DELETE, table)).executeUpdate();
	}

}
