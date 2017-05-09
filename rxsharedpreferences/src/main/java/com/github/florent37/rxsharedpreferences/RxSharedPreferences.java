package com.github.florent37.rxsharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;
import java.util.Set;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by florentchampigny on 09/05/2017.
 */

public class RxSharedPreferences {

    private static final String KEY = "RxSharedPreferences";

    private final SharedPreferences sharedPreferences;

    //region init

    public RxSharedPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public RxSharedPreferences(Context context) {
        this(context.getSharedPreferences(KEY, Context.MODE_PRIVATE));
    }

    public static RxSharedPreferences with(Context context) {
        return new RxSharedPreferences(context);
    }

    public static RxSharedPreferences with(SharedPreferences sharedPreferences) {
        return new RxSharedPreferences(sharedPreferences);
    }

    //endregion

    //region getters

    public Observable<Boolean> getBoolean(final String key, final boolean defaultValue) {
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Boolean> e) throws Exception {
                e.onNext(sharedPreferences.getBoolean(key, defaultValue));
                e.onComplete();
            }
        });
    }

    public Observable<String> getString(final String key, final String defaultValue) {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                e.onNext(sharedPreferences.getString(key, defaultValue));
                e.onComplete();
            }
        });
    }

    public Observable<Set<String>> getString(final String key, final Set<String> defaultValue) {
        return Observable.create(new ObservableOnSubscribe<Set<String>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Set<String>> e) throws Exception {
                e.onNext(sharedPreferences.getStringSet(key, defaultValue));
                e.onComplete();
            }
        });
    }

    public Observable<Float> getFloat(final String key, final float defaultValue) {
        return Observable.create(new ObservableOnSubscribe<Float>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Float> e) throws Exception {
                e.onNext(sharedPreferences.getFloat(key, defaultValue));
                e.onComplete();
            }
        });
    }

    public Observable<Long> getLong(final String key, final long defaultValue) {
        return Observable.create(new ObservableOnSubscribe<Long>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Long> e) throws Exception {
                e.onNext(sharedPreferences.getLong(key, defaultValue));
                e.onComplete();
            }
        });
    }

    public Observable<Integer> getInt(final String key, final int defaultValue) {
        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(sharedPreferences.getInt(key, defaultValue));
                e.onComplete();
            }
        });
    }

    public Observable<Map<String, ?>> getAll() {
        return Observable.create(new ObservableOnSubscribe<Map<String, ?>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Map<String, ?>> e) throws Exception {
                e.onNext(sharedPreferences.getAll());
                e.onComplete();
            }
        });
    }

    //endregion

    //region setters

    public Observable<String> putString(final String key, final String value) {
        return Observable.just(value)
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String v) throws Exception {
                        sharedPreferences.edit().putString(key, v).apply();
                    }
                });
    }

    public Observable<Boolean> putBoolean(final String key, final Boolean value) {
        return Observable.just(value)
                .doOnNext(new Consumer<Boolean>() {
                    @Override
                    public void accept(@NonNull Boolean v) throws Exception {
                        sharedPreferences.edit().putBoolean(key, v).apply();
                    }
                });
    }

    public Observable<Set<String>> putStringSet(final String key, final Set<String> value) {
        return Observable.just(value)
                .doOnNext(new Consumer<Set<String>>() {
                    @Override
                    public void accept(@NonNull Set<String> v) throws Exception {
                        sharedPreferences.edit().putStringSet(key, v).apply();
                    }
                });
    }

    public Observable<Long> putLong(final String key, final Long value) {
        return Observable.just(value)
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long v) throws Exception {
                        sharedPreferences.edit().putLong(key, v).apply();
                    }
                });
    }

    public Observable<Float> putFloat(final String key, final Float value) {
        return Observable.just(value)
                .doOnNext(new Consumer<Float>() {
                    @Override
                    public void accept(@NonNull Float v) throws Exception {
                        sharedPreferences.edit().putFloat(key, v).apply();
                    }
                });
    }

    public Observable<Integer> putInteger(final String key, final Integer value) {
        return Observable.just(value)
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer v) throws Exception {
                        sharedPreferences.edit().putInt(key, v).apply();
                    }
                });
    }

    //endregion
}
