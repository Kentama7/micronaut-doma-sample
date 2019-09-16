package micronaut.doma.sample.doma

import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import org.seasar.doma.jdbc.Config
import org.seasar.doma.jdbc.ConfigSupport
import org.seasar.doma.jdbc.Naming
import org.seasar.doma.jdbc.dialect.PostgresDialect
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource
import org.seasar.doma.jdbc.tx.LocalTransactionManager
import org.seasar.doma.jdbc.tx.TransactionManager
import javax.inject.Singleton
import javax.sql.DataSource

@Factory
class DomaFactory(
    private val dataSource: DataSource
) {
    @Singleton
    @Bean
    fun config(): DomaConfig {
        val config = DomaConfig()
        val localTxDataSourece = LocalTransactionDataSource(dataSource)
        config.dataSource = localTxDataSourece
        config.transactionManager =
            LocalTransactionManager(localTxDataSourece.getLocalTransaction(ConfigSupport.defaultJdbcLogger))
        return config
    }
}

class DomaConfig : Config {

    private lateinit var dataSource: DataSource

    private lateinit var transactionManager: TransactionManager

    private val dialect = PostgresDialect()

    override fun getDataSource() = dataSource

    fun setDataSource(dataSource: DataSource) {
        this.dataSource = dataSource
    }

    override fun getTransactionManager() = transactionManager

    fun setTransactionManager(transactionManager: TransactionManager) {
        this.transactionManager = transactionManager
    }

    override fun getDialect() = dialect

    override fun getNaming() = Naming.SNAKE_LOWER_CASE!!


}