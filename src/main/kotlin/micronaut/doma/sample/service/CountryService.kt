package micronaut.doma.sample.service

import micronaut.doma.sample.DomaConfig
import micronaut.doma.sample.dao.CountryDao
import micronaut.doma.sample.domain.Country
import java.util.function.Supplier
import javax.inject.Singleton

@Singleton
class CountryService(
    private val config: DomaConfig,
    private val countryDao: CountryDao
) {

    fun findAll(): List<Country> {
        val tm = config.transactionManager
        return tm.required(Supplier {
            countryDao.findAll()
        })
    }

}