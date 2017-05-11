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

# Credits

Author: Florent Champigny [http://www.florentchampigny.com/](http://www.florentchampigny.com/)

Blog : [http://www.tutos-android-france.com/](http://www.www.tutos-android-france.com/)

<a href="https://plus.google.com/+florentchampigny">
  <img alt="Follow me on Google+"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/gplus.png" />
</a>
<a href="https://twitter.com/florent_champ">
  <img alt="Follow me on Twitter"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/twitter.png" />
</a>
<a href="https://www.linkedin.com/in/florentchampigny">
  <img alt="Follow me on LinkedIn"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/linkedin.png" />
</a>

License
--------

    Copyright 2017 Florent37, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
