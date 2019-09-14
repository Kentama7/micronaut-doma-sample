package micronaut.doma.sample.dao

import micronaut.doma.sample.domain.Country
import org.seasar.doma.AnnotateWith
import org.seasar.doma.Annotation
import org.seasar.doma.AnnotationTarget
import org.seasar.doma.Dao
import org.seasar.doma.Select
import javax.inject.Inject
import javax.inject.Singleton

@Dao
@AnnotateWith(annotations = [
    Annotation(target = AnnotationTarget.CLASS, type = Singleton::class),
    Annotation(target = AnnotationTarget.CONSTRUCTOR, type = Inject::class)
])
interface CountryDao {
    @Select
    fun findAll(): List<Country>
}