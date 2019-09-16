package micronaut.doma.sample.annotation

import io.micronaut.aop.MethodInterceptor
import io.micronaut.aop.MethodInvocationContext
import org.seasar.doma.jdbc.Config
import java.util.function.Supplier
import javax.inject.Singleton

@Singleton
class TransactionInterceptor(
    private val config: Config
) : MethodInterceptor<Any, Any> {
    override fun intercept(context: MethodInvocationContext<Any, Any>): Any {
        val txManager = config.transactionManager
        return txManager.required(Supplier { context.proceed() })
    }
}