package dog.snow.androidrecruittest.ui.common.rx

import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

object RxTextWatcher {
    fun fromView(textView: TextInputEditText): Observable<String> {
        val publishSubject = PublishSubject.create<String>()
        textView.addTextChangedListener {
            publishSubject.onNext(it.toString())
        }
        return publishSubject.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }
}