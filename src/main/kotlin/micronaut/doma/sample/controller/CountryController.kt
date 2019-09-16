package micronaut.doma.sample.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import micronaut.doma.sample.doma.DomaConfig
import micronaut.doma.sample.service.CountryService

@Controller
class CountryController(
    private val domaConfig: DomaConfig,
    private val countryService: CountryService
) {

    @Get
    fun index() = countryService.findAll()

    @Get("kato")
    fun kato(): String {
        return "kato"
    }
}