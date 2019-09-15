package micronaut.doma.sample.annotation

import io.micronaut.aop.MethodInterceptor
import io.micronaut.aop.MethodInvocationContext
import micronaut.doma.sample.DomaConfig
import java.util.function.Supplier
import javax.inject.Singleton

@Singleton
class TransactionInterceptor(
    private val domaConfig: DomaConfig
) : MethodInterceptor<Any, Any> {
    override fun intercept(context: MethodInvocationContext<Any, Any>): Any {
        val txManager = domaConfig.transactionManager
        return txManager.required(Supplier { context.proceed() })
    }

}