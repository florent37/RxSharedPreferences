package florent37.github.com.rxsharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.github.florent37.rxsharedpreferences.RxSharedPreferences;

import io.reactivex.Observable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        final RxSharedPreferences rxShared = RxSharedPreferences.with(sharedPreferences);

        rxShared.putString("user.firstName", "Florent")
                .flatMap(firstName -> rxShared.putString("user.lastName", "Champigny"))
                .flatMap(lastName -> rxShared.putString("user.pseudo", "florent37"))
                .flatMap(pseudo -> rxShared.putInteger("user.age", 26))

                .flatMap(age -> rxShared.getAll())
                .flatMap(stringMap -> Observable.fromIterable(stringMap.entrySet()))
                .map(Object::toString)

                .subscribe(s -> Log.d("TAG", s));

        rxShared.getInt("user.age", 0)
                .subscribe(age -> {
                    //display age
                    Log.d("TAG", "age: " + age);
                });

        Observable.just(new User())
                .flatMap(user -> rxShared.getInt("user.age", 0), (user, age) -> {
                    user.setAge(age);
                    return user;
                })
                .flatMap(user -> rxShared.getString("user.pseudo", ""), (user, pseudo) -> {
                    user.setPseudo(pseudo);
                    return user;
                })

                .subscribe(user -> {
                    //display user
                    Log.d("TAG", user.toString());
                });
    }
}
