package micronaut.doma.sample

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("micronaut.doma.sample")
                .mainClass(Application.javaClass)
                .start()
    }
}