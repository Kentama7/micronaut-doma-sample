package micronaut.doma.sample.dao

import micronaut.doma.sample.DomaConfig
import micronaut.doma.sample.domain.Country
import org.seasar.doma.AnnotateWith
import org.seasar.doma.Annotation
import org.seasar.doma.AnnotationTarget
import org.seasar.doma.Dao
import org.seasar.doma.Select
import javax.inject.Singleton

@Dao(config = DomaConfig::class)
@AnnotateWith(annotations = [
    Annotation(target= AnnotationTarget.CLASS, type = Singleton::class)
])
interface CountryDao {
    @Select
    fun findAll(): List<Country>
}