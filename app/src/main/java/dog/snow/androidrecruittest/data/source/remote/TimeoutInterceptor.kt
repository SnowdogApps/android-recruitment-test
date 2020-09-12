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

    override fun intercept(chain: Interceptor.Chain): Response = chain.tryToRetry()


    private fun Request.addUserAgentHeader(): Request = newBuilder()
        .addHeader(HeaderUtils.USER_AGENT_LABEL, HeaderUtils.USER_AGENT_VALUE)
        .build()

    private fun Interceptor.Chain.tryToRetry(): Response = try {
            val response = proceed(request().addUserAgentHeader())
            Log.i(TAG, "Succeed.")
            retryCount = 0
            response
        } catch (e: SocketTimeoutException) {
            Log.e(TAG, "Timeout. Retries: $retryCount")
            if (retryCount < RETRIES) {
                ++retryCount
                tryToRetry()
            } else {
                retryCount = 0
                throw SocketTimeoutException()
            }
        }

  /*  private val Response.retryCount: Int
        get() {
            var currentResponse = priorResponse()
            var result = 0
            while (currentResponse != null) {
                result++
                currentResponse = currentResponse.priorResponse()
            }
            return result
        }*/

    companion object {
        private val TAG = TimeoutInterceptor::class.simpleName
        private const val RETRIES = 2
    }
}