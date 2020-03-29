package com.tongfu.mytestapp.architecture.paging;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;
import androidx.paging.ItemKeyedDataSource;

import com.j256.ormlite.stmt.query.In;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FakePersonDao {
    private static char[] firstWords = { '赵' , '钱' , '孙' , '李' , '周' , '吴' , '郑' , '王' , '冯' , '陈' };
    private static char[] secondWord = { '子' , '思' , '若' , '晓' , '宝' , '兴' , '志' , '永' , '爱' , '立' };
    private static char[] thirdWord =  { '军' , '伟' , '鹏' , '婷' , '静' , '天' , '辉' , '宇' , '杰' , '阳' };
    private static int[] indexes = new int[1000];
    static {
        Random random = new Random();
        for( int i = 0 ; i < indexes.length ; i++){
            indexes[i] = random.nextInt() ;
            if( indexes[i] < 0 ){
                indexes[i] = - indexes[i] ;
            }
        }
    }
    public DataSource.Factory<Integer , Person> getPersons(){
        return new DataSource.Factory<Integer, Person>(){
            @NonNull
            @Override
            public DataSource<Integer, Person> create() {
                return new ItemKeyedDataSource<Integer , Person>(){
                    @Override
                    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Person> callback) {
                        int startIndex = params.requestedInitialKey == null ? 0 : params.requestedInitialKey ;
                        List<Person> personList = new ArrayList<>();
                        if(startIndex < 1000){
                            int endIndex = startIndex + params.requestedLoadSize ;
                            endIndex = endIndex > 1000 ? 1000 : endIndex ;
                            for(int i = startIndex ; i < endIndex ; i++){
                                StringBuilder stringBuilder = new StringBuilder();
                                int tmpIndex = indexes[i];
                                String name = stringBuilder.append(firstWords[(tmpIndex %1000) / 100] ).append(secondWord[(tmpIndex %100) / 10]).append(thirdWord[tmpIndex % 10] ).toString();
                                Person person = new Person();
                                person.setId(i);
                                person.setName(name);
                                personList.add(person);
                            }
                        }

                        callback.onResult(personList);
                    }

                    @Override
                    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Person> callback) {
                        int startIndex = params.key+1 ;
                        List<Person> personList = new ArrayList<>();
                        if(startIndex < 1000){
                            int endIndex = startIndex + params.requestedLoadSize ;
                            endIndex = endIndex > 1000 ? 1000 : endIndex ;
                            for(int i = startIndex ; i < endIndex ; i++){
                                StringBuilder stringBuilder = new StringBuilder();
                                int tmpIndex = indexes[i];
                                String name = stringBuilder.append(firstWords[(tmpIndex %1000) / 100] ).append(secondWord[(tmpIndex %100) / 10]).append(thirdWord[tmpIndex % 10] ).toString();
                                Person person = new Person();
                                person.setId(i);
                                person.setName(name);
                                personList.add(person);
                            }
                        }
                        callback.onResult(personList);
                    }

                    @Override
                    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Person> callback) {
                        int startIndex = params.key ;
                        List<Person> personList = new ArrayList<>();
                        if(startIndex > 0) {
                            int endIndex = startIndex - params.requestedLoadSize ;
                            endIndex = endIndex >0 ? endIndex : 0 ;

                            for(int i = startIndex-1 ; i >= endIndex ; i--){
                                StringBuilder stringBuilder = new StringBuilder();
                                int tmpIndex = indexes[i];
                                String name = stringBuilder.append(firstWords[(tmpIndex %1000) / 100] ).append(secondWord[(tmpIndex %100) / 10]).append(thirdWord[tmpIndex % 10] ).toString();
                                Person person = new Person();
                                person.setId(i);
                                person.setName(name);
                                personList.add(person);
                            }
                        }

                        callback.onResult(personList);
                    }

                    @NonNull
                    @Override
                    public Integer getKey(@NonNull Person item) {
                        return item.getId();
                    }
                };
            }
        } ;
    }
}
