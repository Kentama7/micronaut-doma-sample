package micronaut.doma.sample.service

import micronaut.doma.sample.annotation.Transactional
import micronaut.doma.sample.dao.CountryDao
import micronaut.doma.sample.domain.Country
import javax.inject.Singleton

@Singleton
@Transactional
class CountryService(
    private val countryDao: CountryDao
) {

    fun findAll(): List<Country> {
        return countryDao.findAll()
    }

}