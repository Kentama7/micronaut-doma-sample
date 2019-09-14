package micronaut.doma.sample

import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import io.micronaut.context.annotation.Requires
import org.seasar.doma.jdbc.Config
import org.seasar.doma.jdbc.ConfigSupport
import org.seasar.doma.jdbc.Naming
import org.seasar.doma.jdbc.dialect.PostgresDialect
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource
import org.seasar.doma.jdbc.tx.LocalTransactionManager
import javax.inject.Inject
import javax.inject.Singleton
import javax.sql.DataSource

@Requires(classes = [LocalTransactionDataSource::class, LocalTransactionManager::class])
@Singleton
class DomaConfig : Config {

    private val dialect = PostgresDialect()

    @Inject
    private lateinit var dataSource: LocalTransactionDataSource

    @Inject
    private lateinit var transactionManager: LocalTransactionManager

    override fun getDialect() = dialect

    override fun getDataSource() = dataSource

    override fun getTransactionManager() = transactionManager

    override fun getNaming() = Naming.SNAKE_LOWER_CASE!!
}

@Factory
class DomaConfigFactory {

    @Bean
    fun localTransactionDataSource(dataSource: DataSource) = LocalTransactionDataSource(dataSource)

    @Bean
    fun localTransactionManager(dataSource: LocalTransactionDataSource) =
        LocalTransactionManager(dataSource.getLocalTransaction(ConfigSupport.defaultJdbcLogger))
}