package dog.snow.androidrecruittest.data.source.remote

import android.util.Log
import dog.snow.androidrecruittest.utils.HeaderUtils
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.net.SocketTimeoutException
import javax.inject.Inject


class TimeoutInterceptor @Inject constructor() : Interceptor {
    private var retryCount = 0

    override fun intercept(chain: Interceptor.Chain): Response = chain.tryProceed()

    private fun Request.addUserAgentHeader(): Request = newBuilder()
        .addHeader(HeaderUtils.USER_AGENT_LABEL, HeaderUtils.USER_AGENT_VALUE)
        .build()

    private fun Interceptor.Chain.begin(request: Request) = proceed(request.addUserAgentHeader())

    private fun Interceptor.Chain.tryProceed(): Response = try {
        begin(request()).apply { retryCount = 0 }
    } catch (e: SocketTimeoutException) {
        Log.e(TAG, "Retries - $retryCount.")
        if (retryCount < RETRIES) {
            ++retryCount
            tryProceed()
        } else
            throw SocketTimeoutException().apply { retryCount = 0 }
    }

    companion object {
        private val TAG = TimeoutInterceptor::class.simpleName
        private const val RETRIES = 2
    }
}