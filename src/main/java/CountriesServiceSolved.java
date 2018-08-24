import com.sun.tools.javac.util.Pair;

import java.util.List;
import java.util.Map;
import java.util.concurrent.FutureTask;
import java.util.function.BiFunction;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;

class CountriesServiceSolved implements CountriesService {

    @Override
    public Single<String> countryNameInCapitals(Country country) {
        return Single.create(e -> {
            e.onSuccess(country.name.toUpperCase());
        });
    }

    public Single<Integer> countCountries(List<Country> countries) {
        return Single.create(e -> {
            e.onSuccess(countries.size());
        });
    }

    public Observable<Long> listPopulationOfEachCountry(List<Country> countries) {
        return Observable.fromIterable(countries)
                .map(it -> it.population);
    }

    @Override
    public Observable<String> listNameOfEachCountry(List<Country> countries) {
        return Observable.fromIterable(countries)
                .map(it -> it.name);
    }

    @Override
    public Observable<Country> listOnly3rdAnd4thCountry(List<Country> countries) {
        return Observable.fromIterable(countries).skip(2).take(2);

    }

    @Override
    public Single<Boolean> isAllCountriesPopulationMoreThanOneMillion(List<Country> countries) {
        return Observable.fromIterable(countries)
                .all(it -> it.population > 1000000);
    }

    @Override
    public Observable<Country> listPopulationMoreThanOneMillion(List<Country> countries) {
        return Observable.fromIterable(countries)
                .filter(it -> it.population > 1000000);

    }

    @Override
    public Observable<Country> listPopulationMoreThanOneMillionWithTimeoutFallbackToEmpty(final FutureTask<List<Country>> countriesFromNetwork) {
        return null; // put your solution here
    }

    @Override
    public Observable<String> getCurrencyUsdIfNotFound(String countryName, List<Country> countries) {
        return null;
    }

    @Override
    public Observable<Long> sumPopulationOfCountries(List<Country> countries) {
        return Observable.fromIterable(countries)
                .map(it -> it.population)
                .reduce(0L, (sum, item) -> (item + sum))
                .toObservable();
    }

    @Override
    public Single<Map<String, Long>> mapCountriesToNamePopulation(List<Country> countries) {
        return Observable.fromIterable(countries)
                .toMap(it -> it.name, it -> it.population);
    }

    @Override
    public Observable<Long> sumPopulationOfCountries(Observable<Country> countryObservable1,
                                                     Observable<Country> countryObservable2) {
        return Observable.zipIterable(countryObservable1,countryObservable2,)
    }

    @Override
    public Single<Boolean> areEmittingSameSequences(Observable<Country> countryObservable1,
                                                    Observable<Country> countryObservable2) {
        return null; // put your solution here
    }
}
