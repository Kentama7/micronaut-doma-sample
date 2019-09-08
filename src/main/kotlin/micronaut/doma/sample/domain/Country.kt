package micronaut.doma.sample.domain

import org.seasar.doma.Entity
import java.time.LocalDateTime

@Entity(immutable = true)
data class Country(
        val countryId: Int,
        val country: String,
        val lastUpdate: LocalDateTime
)