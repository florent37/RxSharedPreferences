# RxSharedPreferences

RxJava2 binding of Android SharedPreferences

```java
RxSharedPreferences.with(context).putString("user.firstName", "Florent")
                .flatMap(firstName -> rxShared.putInteger("user.age", 26))

                .flatMap(age -> rxShared.getAll())
                .flatMap(stringMap -> Observable.fromIterable(stringMap.entrySet()))
                .map(Object::toString)

                .subscribe(storedValues -> Log.d(TAG, storedValues));
                
RxSharedPreferences.with(context).getInt("user.age", 0)
        .subscribe(age -> {
            //display age
            Log.d(TAG, "age: " + age);
        });
```

# Download

[ ![Download](https://api.bintray.com/packages/florent37/maven/rxsharedpreferences/images/download.svg) ](https://bintray.com/florent37/maven/rxsharedpreferences/_latestVersion)
```java
dependencies {
    compile 'com.github.florent37:rxsharedpreferences:1.0.0'
}
```

# Initialize

```java
//With Context
final RxSharedPreferences rxShared = RxSharedPreferences.with(context);

//With SharedPreferences
final SharedPreferences sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE);
final RxSharedPreferences rxShared = RxSharedPreferences.with(sharedPreferences);
```

# Setters

```
rxShared.putString(key, value) //Observable<String>
rxShared.putBoolean(key, value) //Observable<Boolean>
...
```

# Getters

```
rxShared.getString(key) //Observable<String>
rxShared.getBoolean(key) //Observable<Boolean>
...
```